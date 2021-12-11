package com.ec.final_project.Services;

public interface taikhoan_thanhtoanService {
    void addtkTT(double sotien,String sotaikhoan,int acc_id);
    void updatetkTT(double sotien,int acc_id);
    void updatetkTT_AfterCreate_tkTK(double sotien,int acc_id);
}
