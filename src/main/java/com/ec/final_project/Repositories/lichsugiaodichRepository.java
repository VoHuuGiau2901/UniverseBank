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
            "       (SELECT sum(tkTT.SoTien) FROM taikhoan_thanhtoan tkTT)c,\n" +
            "       (SELECT sum(lsgd.SoTienGiaoDich)\n" +
            "        FROM lichsugiaodich lsgd\n" +
            "        WHERE YEAR(lsgd.Ngay) = YEAR(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
            "          AND MONTH(lsgd.Ngay) = MONTH(CURRENT_DATE - INTERVAL 1 MONTH)\n" +
            "          AND lsgd.HinhThuc=1)d",nativeQuery = true)
    Object get_total_user_and_money();
}
