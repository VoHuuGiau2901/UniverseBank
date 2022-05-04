package com.ec.final_project.Repositories;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface taikhoan_tietkiemRepository extends JpaRepository<taikhoan_tietkiem, Integer> {
    @Modifying
    @Query(value = "insert into taikhoan_tietkiem ( SoTien,SoTaiKhoan, Acc_id)\n" +
            "values (:sotien,:sotaikhoan,:acc_id);", nativeQuery = true)
    @Transactional
    void addtkTK(@Param("sotien") double sotien, @Param("sotaikhoan") String sotaikhoan, @Param("acc_id") int acc_id);

    @Query("SELECT tk,tkTK,tkTT FROM thongtintk tk LEFT JOIN taikhoan_tietkiem tkTK ON tk.Acc_id = tkTK.Acc.Acc_id LEFT join taikhoan_thanhtoan tkTT on tk.Acc_id=tkTT.Acc.Acc_id")
    List<Object> getAccount();

    @Query(value = "SELECT * from taikhoan_tietkiem where Acc_id=:acc_id", nativeQuery = true)
    List<taikhoan_tietkiem> getAllByAcc_id(@Param("acc_id") int acc_id);

    @Query(value = "SELECT * from taikhoan_tietkiem;", nativeQuery = true)
    List<taikhoan_tietkiem> getAll();

    @Modifying(clearAutomatically = true)
    @Query(value = "update taikhoan_thanhtoan tkTT set tkTT.SoTien=tkTT.SoTien+(select tkTK.SoTien*0.001*(DATEDIFF(CURDATE(),tkTK.NgayGui)/360)  from taikhoan_tietkiem tkTK where tkTK.id=:id)" +
            " + (select tkTK.SoTien from taikhoan_tietkiem tkTK where tkTK.id=:id)", nativeQuery = true)
    @Transactional
    void Cancel_Saving(@Param("id") int id);

    @Modifying(clearAutomatically = true)
    @Query(value = "insert into lichsustonk (id, NgayStonk, LaiSuat, Stonk, saving_account_id)\n" +
            "select tkTK.id,\n" +
            "       tkTK.NgayDaoHan,\n" +
            "       LS.LaiSuat,\n" +
            "       tkTK.SoTien * LS.LaiSuat,\n" +
            "       tkTK.Acc_id\n" +
            "from taikhoan_tietkiem tkTK\n" +
            "         join laisuat LS on tkTK.KyHan = LS.KyHan\n" +
            "where tkTK.NgayDaoHan = CURDATE();\n" +
            "\n" +
            "update taikhoan_thanhtoan tkTT,(select sum(SoTien * LaiSuat) as sotien, Acc_id\n" +
            "                                from taikhoan_tietkiem\n" +
            "                                         join laisuat l on taikhoan_tietkiem.KyHan = l.KyHan\n" +
            "                                where NgayDaoHan = CURDATE()\n" +
            "                                group by Acc_id) as tkTK\n" +
            "set tkTT.SoTien=tkTT.SoTien + tkTK.sotien\n" +
            "where tkTT.Acc_id = tkTK.Acc_id;\n" +
            "update taikhoan_thanhtoan tkTT,(select sum(SoTien) as sotien, Acc_id\n" +
            "                                from taikhoan_tietkiem\n" +
            "                                where NgayDaoHan = CURDATE()\n" +
            "                                group by Acc_id) as tkTK\n" +
            "set tkTT.SoTien=tkTT.SoTien + tkTK.sotien\n" +
            "where tkTT.Acc_id = tkTK.Acc_id;\n" +
            "\n" +
            "delete\n" +
            "from taikhoan_tietkiem tkTK\n" +
            "where tkTK.NgayDaoHan = CURDATE()\n" +
            "  and tkTK.TuyChon = 2;\n" +
            "\n" +
            "update taikhoan_tietkiem t ,(select tkTK.SoTien, tkTK.NgayGui, tkTK.NgayDaoHan, l.LaiSuat, l.KyHan\n" +
            "                             from taikhoan_tietkiem tkTK\n" +
            "                                      inner join laisuat l on tkTK.KyHan = l.KyHan\n" +
            "                             where NgayDaoHan = CURDATE()) as TK\n" +
            "set t.NgayDaoHan=DATE_ADD(t.NgayDaoHan, INTERVAL t.KyHan month),\n" +
            "    t.NgayGui= CURDATE(),\n" +
            "    t.SoTien=t.SoTien + (TK.SoTien * TK.LaiSuat)\n" +
            "where t.NgayDaoHan = CURDATE();", nativeQuery = true)
    @Transactional
    void check();
}
