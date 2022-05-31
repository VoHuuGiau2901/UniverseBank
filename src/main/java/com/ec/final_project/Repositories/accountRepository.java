package com.ec.final_project.Repositories;

import com.ec.final_project.Entity.useraccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface accountRepository extends JpaRepository<useraccount, Integer> {

    @Query("SELECT tk FROM useraccount tk WHERE tk.username = :username or tk.phone=:phone or tk.email=:email or tk.identity_number=:identity_number")
    useraccount checkExists(@Param("username") String username, @Param("phone") String phone, @Param("email") String email, @Param("identity_number") String identity_number);

    @Query(value = "SELECT * from useraccount where username=:username and password=:password", nativeQuery = true)
    useraccount validate(@Param("username") String username, @Param("password") String password);

    @Query(value = "SELECT * from useraccount where email=:email", nativeQuery = true)
    useraccount FindByEmail(@Param("email") String email);

    @Modifying(clearAutomatically = true)
    @Query(value = "update useraccount set password=:password where acc_id=:acc_id", nativeQuery = true)
    @Transactional
    void UpdatePassword(@Param("acc_id") int acc_id, @Param("password") String password);

    @Query(value = "select * from useraccount left join pay_account pa on useraccount.acc_id = pa.acc_id \n" +
            "    left join saving_account sa on useraccount.acc_id = sa.acc_id\n" +
            "    where identity_number=:identityNumber", nativeQuery = true)
    useraccount findByIdentityNumber(@Param("identityNumber") String identityNumber);
}
