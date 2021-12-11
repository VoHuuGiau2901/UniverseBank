package com.ec.final_project.Services;

import java.util.List;

public interface taikhoan_tietkiemService {
//    List<taikhoan_tietkiem> getAll();

    void addtkTK(double sotien, String sotaikhoan, int acc_id);

    List<Object> get_thongtintk_join_taikhoan_tietkiem_join_taikhoan_thanhtoan();

    void updatetkTK(double sotien, String ngaygui,String ngaydaohan,String tuychon,String kyhan,int acc_id);
}
