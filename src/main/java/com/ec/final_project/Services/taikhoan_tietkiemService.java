package com.ec.final_project.Services;

import com.ec.final_project.Beans.taikhoan_tietkiem;

import java.util.List;

public interface taikhoan_tietkiemService {
//    List<taikhoan_tietkiem> getAll();

    void addtkTK(taikhoan_tietkiem tkTK);

    List<Object> get_thongtintk_join_taikhoan_tietkiem_join_taikhoan_thanhtoan();

//    void updatetkTK(double sotien, String ngaygui,String ngaydaohan,String tuychon,String kyhan,int acc_id);
}
