package com.ec.final_project.Services;

import com.ec.final_project.Beans.taikhoan_tietkiem;

import java.util.List;

public interface taikhoan_tietkiemService {
    List<taikhoan_tietkiem> getAll();
    void addtkTK(taikhoan_tietkiem tkTK);
    List<Object> get_thongtintk_join_taikhoan_tietkiem_join_taikhoan_thanhtoan();
}
