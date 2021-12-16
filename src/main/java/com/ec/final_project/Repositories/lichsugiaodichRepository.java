package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.lichsugiaodich;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface lichsugiaodichRepository extends JpaRepository<lichsugiaodich,Integer> {

    @Query(value = "SELECT count(tk.Acc_id) as total_customers,sum(tkTK.sotien) as total_saving_money,sum(tkTT.sotien) as total_payment_money" +
            " FROM thongtintk tk " +
            "LEFT JOIN taikhoan_tietkiem tkTK ON tk.Acc_id = tkTK.acc_id " +
            "LEFT join taikhoan_thanhtoan tkTT on tk.Acc_id=tkTT.acc_id",nativeQuery = true)
    Object get_total_user_and_money();
}
