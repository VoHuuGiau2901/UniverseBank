package com.ec.final_project.Repositories;

import com.ec.final_project.Entity.pay_account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface pay_accountRepository extends JpaRepository<pay_account, Integer> {
    @Modifying
    @Query(value = "insert into pay_account ( balance,account_number, acc_id)\n" +
            "values (:balance,:account_number,:acc_id);", nativeQuery = true)
    @Transactional
    void addtkTT(@Param("balance") double balance, @Param("account_number") String account_number, @Param("acc_id") int acc_id);

    @Modifying(clearAutomatically = true)
    @Query(value = "update pay_account " +
            "set balance=balance+:balance " +
            "where acc_id=:acc_id", nativeQuery = true)
    @Transactional
    void Update(@Param("balance") double balance, @Param("acc_id") int acc_id);

    @Query(value = "select ttTK.*,tkTT.balance,a.tong_so_taiKhoan from\n" +
            "useraccount ttTK join pay_account tkTT on ttTK.acc_id = tkTT.acc_id\n" +
            " left join (select count(tkTK.id) as tong_so_taiKhoan,tkTK.acc_id\n" +
            "      from saving_account tkTK group by tkTK.Acc_id)a on ttTK.Acc_id=a.acc_id",nativeQuery = true)
    List<Object> getAll();
}

