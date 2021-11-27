package com.ec.final_project.Services;

import com.ec.final_project.Beans.TaiKhoanTietKiem;

import java.util.List;

public interface TaiKhoanTietKiemService{
    public List<TaiKhoanTietKiem> getAlltkTK();
    public List<TaiKhoanTietKiem> getAllByAccID(int id);
}
