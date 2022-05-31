package com.ec.final_project.Repositories;

import com.ec.final_project.Entity.transaction_history;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface transaction_historyRepository extends JpaRepository<transaction_history, Integer> {

    @Query(value = "SELECT (SELECT count(DISTINCT tk.Acc_id) from useraccount tk)a,\n" +
            "       (SELECT sum(tkTK.deposit) as total_payment_money FROM saving_account tkTK)b,\n" +
            "       (SELECT sum(tkTT.balance) FROM pay_account tkTT)c;", nativeQuery = true)
    Object get_total_user_and_money();

    @Query(value = "SELECT b.tongtien, (b.tongtien/a.tongtien)*100 -100 , b.period\n" +
            "from (SELECT sum(tkTK.deposit) as tongtien, tkTK.period\n" +
            "      FROM saving_account tkTK\n" +
            "      WHERE YEAR(tkTK.start_date) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
            "        AND MONTH(tkTK.start_date) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
            "      group by tkTK.period) a,\n" +
            "     (SELECT sum(tkTK.deposit) as tongtien, tkTK.period\n" +
            "      FROM saving_account tkTK\n" +
            "      WHERE YEAR(tkTK.start_date) = YEAR(CURRENT_DATE)\n" +
            "        AND MONTH(tkTK.start_date) = MONTH(CURRENT_DATE)\n" +
            "      group by tkTK.period) b\n" +
            "where b.period = a.period\n" +
            "group by b.period;", nativeQuery = true)
    List<Object> getProfit();


    @Query(value = "SELECT *from transaction_history where acc_id=:acc_id", nativeQuery = true)
    List<transaction_history> getAll_lsGDByID(@Param("acc_id") int acc_id);
}
