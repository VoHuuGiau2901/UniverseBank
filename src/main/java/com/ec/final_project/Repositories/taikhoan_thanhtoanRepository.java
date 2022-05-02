package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.taikhoan_thanhtoan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface taikhoan_thanhtoanRepository extends JpaRepository<taikhoan_thanhtoan, Integer> {
    @Modifying
    @Query(value = "insert into taikhoan_thanhtoan ( SoTien,SoTaiKhoan, Acc_id)\n" +
            "values (:sotien,:sotaikhoan,:acc_id);", nativeQuery = true)
    @Transactional
    void addtkTT(@Param("sotien") double sotien, @Param("sotaikhoan") String sotaikhoan, @Param("acc_id") int acc_id);

    @Modifying(clearAutomatically = true)
    @Query(value = "update taikhoan_thanhtoan " +
            "set SoTien=SoTien+:sotien " +
            "where Acc_id=:acc_id", nativeQuery = true)
    @Transactional
    void Update(@Param("sotien") double s, @Param("acc_id") int a);

    @Query(value = "select ttTK.*,tkTT.SoTien,a.tong_so_taiKhoan from\n" +
            "thongtintk ttTK join taikhoan_thanhtoan tkTT on ttTK.acc_id = tkTT.acc_id\n" +
            " left join (select count(tkTK.id) as tong_so_taiKhoan,tkTK.acc_id\n" +
            "      from taikhoan_tietkiem tkTK group by tkTK.Acc_id)a on ttTK.Acc_id=a.acc_id",nativeQuery = true)
    List<Object> getAll();
}

