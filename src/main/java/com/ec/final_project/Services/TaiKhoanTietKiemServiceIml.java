package com.ec.final_project.Services;

import com.ec.final_project.Beans.TaiKhoanTietKiem;
import com.ec.final_project.Repositories.TaiKhoanTietKiemRepository;

import java.util.List;

public class TaiKhoanTietKiemServiceIml implements TaiKhoanTietKiemService{
    private TaiKhoanTietKiemRepository tkTK;

    @Override
    public List<TaiKhoanTietKiem> getAlltkTK() {
        return tkTK.findAll();
    }

    @Override
    public List<TaiKhoanTietKiem> getAllByAccID(int id) {
        return tkTK.getAllByAcc_id(id);
    }

}
