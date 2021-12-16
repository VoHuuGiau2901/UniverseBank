package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.lichsugiaodich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface lichsugiaodichRepository extends JpaRepository<lichsugiaodich,Integer> {

    @Query(value = "SELECT (SELECT count(DISTINCT tk.Acc_id) from thongtintk tk)a,\n" +
            "       (SELECT sum(tkTK.SoTien) as total_payment_money FROM taikhoan_tietkiem tkTK)b,\n" +
            "       (SELECT sum(tkTT.SoTien) FROM taikhoan_thanhtoan tkTT)c;",nativeQuery = true)
    Object get_total_user_and_money();

    @Query(value = "SELECT b.tongtien/a.tongtien, b.KyHan\n" +
            "from (SELECT sum(tkTK.SoTien) as tongtien, tkTK.KyHan\n" +
            "      FROM taikhoan_tietkiem tkTK\n" +
            "      WHERE YEAR(tkTK.NgayGui) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
            "        AND MONTH(tkTK.NgayGui) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
            "      group by tkTK.KyHan) a,\n" +
            "     (SELECT sum(tkTK.SoTien) as tongtien, tkTK.KyHan\n" +
            "      FROM taikhoan_tietkiem tkTK\n" +
            "      WHERE YEAR(tkTK.NgayGui) = YEAR(CURRENT_DATE)\n" +
            "        AND MONTH(tkTK.NgayGui) = MONTH(CURRENT_DATE)\n" +
            "      group by tkTK.KyHan) b\n" +
            "where b.KyHan = a.KyHan\n" +
            "group by b.KyHan;",nativeQuery = true)
    List<Object> get_money_percent_stonk_per_period();
}
