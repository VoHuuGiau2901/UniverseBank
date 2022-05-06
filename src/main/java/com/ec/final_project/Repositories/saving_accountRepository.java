package com.ec.final_project.Repositories;

import com.ec.final_project.Entity.saving_account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface saving_accountRepository extends JpaRepository<saving_account, Integer> {
    @Modifying
    @Query(value = "insert into saving_account ( deposit,account_number, Acc_id)\n" +
            "values (:sotien,:sotaikhoan,:acc_id);", nativeQuery = true)
    @Transactional
    void addtkTK(@Param("sotien") double sotien, @Param("sotaikhoan") String sotaikhoan, @Param("acc_id") int acc_id);

    @Query("SELECT tk,tkTT,tk.Acc_id FROM useraccount tk LEFT join pay_account tkTT on tk.Acc_id=tkTT.Acc.Acc_id where tk.Acc_id=:acc_id")
    List<Object> getAccount(@Param("acc_id") int acc_id);

    @Query(value = "SELECT * from saving_account where Acc_id=:acc_id", nativeQuery = true)
    List<saving_account> getAllByAcc_id(@Param("acc_id") int acc_id);

    @Query(value = "SELECT * from saving_account;", nativeQuery = true)
    List<saving_account> getAll();

    @Modifying(clearAutomatically = true)
    @Query(value = "update pay_account tkTT set tkTT.balance=tkTT.balance+(select tkTK.deposit*0.001*(DATEDIFF(CURDATE(),tkTK.start_date)/360)  from saving_account tkTK where tkTK.id=:id)" +
            " + (select tkTK.deposit from saving_account tkTK where tkTK.id=:id)", nativeQuery = true)
    @Transactional
    void Cancel_Saving(@Param("id") int id);

    @Modifying(clearAutomatically = true)
    @Query(value = "insert into profit_history (id, date, interest_rate,profit , saving_account_id)\n" +
            "select tkTK.id,\n" +
            "       tkTK.end_date,\n" +
            "       LS.interest_rate,\n" +
            "       tkTK.deposit * LS.interest_rate,\n" +
            "       tkTK.Acc_id\n" +
            "from saving_account tkTK\n" +
            "         join interest_rate LS on tkTK.period = LS.period\n" +
            "where tkTK.end_date = CURDATE();\n" +
            "\n" +
            "update pay_account tkTT,(select sum(deposit * interest_rate) as sotien, Acc_id\n" +
            "                                from saving_account\n" +
            "                                         join interest_rate l on saving_account.period = l.period\n" +
            "                                where end_date = CURDATE()\n" +
            "                                group by Acc_id) as tkTK\n" +
            "set tkTT.balance=tkTT.balance + tkTK.sotien\n" +
            "where tkTT.Acc_id = tkTK.Acc_id;\n" +
            "update pay_account tkTT,(select sum(deposit) as sotien, Acc_id\n" +
            "                                from saving_account\n" +
            "                                where end_date = CURDATE()\n" +
            "                                group by Acc_id) as tkTK\n" +
            "set tkTT.balance=tkTT.balance + tkTK.sotien\n" +
            "where tkTT.Acc_id = tkTK.Acc_id;\n" +
            "\n" +
            "delete\n" +
            "from saving_account tkTK\n" +
            "where tkTK.end_date = CURDATE()\n" +
            "  and tkTK.saving_option = 2;\n" +
            "\n" +
            "update saving_account t ,(select tkTK.deposit, tkTK.start_date, tkTK.end_date, l.interest_rate, l.period\n" +
            "                             from saving_account tkTK\n" +
            "                                      inner join interest_rate l on tkTK.period = l.period\n" +
            "                             where end_date = CURDATE()) as TK\n" +
            "set t.end_date=DATE_ADD(t.end_date, INTERVAL t.period month),\n" +
            "    t.start_date= CURDATE(),\n" +
            "    t.deposit=t.deposit + (TK.deposit * TK.interest_rate)\n" +
            "where t.end_date = CURDATE();", nativeQuery = true)
    @Transactional
    void check();
}
