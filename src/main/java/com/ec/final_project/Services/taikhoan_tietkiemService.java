package com.ec.final_project.Services;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Beans.thongtintk;

import java.util.Date;
import java.util.List;

public interface taikhoan_tietkiemService {
    public List<taikhoan_tietkiem> getAll();
    public void addtkTK(int sotien,String sotaikhoan,int acc_id);
    public List<Object> get_thongtintk_join_taikhoan_tietkiem();
    public void updatetkTK(int acc_id, int sotien, String ngaygui);
}
