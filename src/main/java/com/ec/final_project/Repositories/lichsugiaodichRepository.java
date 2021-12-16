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
}
