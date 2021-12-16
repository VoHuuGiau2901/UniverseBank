package com.ec.final_project.Services;

import java.util.List;

public interface taikhoan_thanhtoanService {
    void addtkTT(double sotien,String sotaikhoan,int acc_id);
    void updatetkTT(double sotien,int acc_id);
    void updatetkTT_AfterCreate_tkTK(double sotien,int acc_id);
    void updatetkTT_After_Withdraw(double sotien,int acc_id);
    List<Object> thongtinTK_and_tong_sotien_thanhtoan_and_tong_so_taikhoan_tietkiem();
}
