package com.ec.final_project.Repositories;

import com.ec.final_project.Entity.account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface accountRepository extends JpaRepository<account,Integer> {

    @Query("SELECT tk FROM account tk WHERE tk.username = :username or tk.phone=:phone or tk.email=:email or tk.identity_number=:identity_number")
    account checktaikhoanExists(@Param("username") String username, @Param("phone") String phone, @Param("email")String email, @Param("identity_number")String identity_number);

//    @Query("SELECT tk FROM thongtintk tk WHERE tk.taikhoan = :taikhoan AND tk.matkhau = :matkhau")
//    thongtintk findBytaikhoanANDmatkhau(@Param("taikhoan") String taikhoan,@Param("matkhau") String matkhau);
}
