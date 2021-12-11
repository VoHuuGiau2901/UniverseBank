package com.ec.final_project.Services;
import com.ec.final_project.Repositories.taikhoan_tietkiemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taikhoan_tietkiemServiceImpl implements taikhoan_tietkiemService {
    @Autowired
    private taikhoan_tietkiemRepository tkTKRepository;

    @Override
    public void addtkTK(double sotien, String sotaikhoan, int acc_id) {
        tkTKRepository.addtkTK(sotien, sotaikhoan, acc_id);
    }

    @Override
    public List<Object> get_thongtintk_join_taikhoan_tietkiem_join_taikhoan_thanhtoan() {
        return tkTKRepository.get_thongtintk_join_taikhoan_tietkiem_join_taikhoan_thanhtoan();
    }

    @Override
    public void updatetkTK(double sotien, String ngaygui,String ngaydaohan,String tuychon,String kyhan,int acc_id) {
        tkTKRepository.updatetkTK(sotien,ngaygui,ngaydaohan,tuychon,kyhan,acc_id);
    }
}
