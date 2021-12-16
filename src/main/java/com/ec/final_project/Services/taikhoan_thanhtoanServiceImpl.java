package com.ec.final_project.Services;

import com.ec.final_project.Repositories.taikhoan_thanhtoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taikhoan_thanhtoanServiceImpl implements taikhoan_thanhtoanService {

    @Autowired
    private taikhoan_thanhtoanRepository tkTTRepository;

    @Override
    public void addtkTT(double sotien, String sotaikhoan, int acc_id) {
        tkTTRepository.addtkTT(sotien,sotaikhoan,acc_id);
    }

    @Override
    public void updatetkTT(double sotien, int acc_id) {
        tkTTRepository.updatetkTT(sotien,acc_id);
    }

    @Override
    public void updatetkTT_AfterCreate_tkTK(double sotien, int acc_id) {
        tkTTRepository.updatetkTT_AfterCreate_tkTK(sotien,acc_id);
    }

    @Override
    public void updatetkTT_After_Withdraw(double sotien, int acc_id) {
        tkTTRepository.updatetkTT_After_Withdraw(sotien,acc_id);
    }

    @Override
    public List<Object> thongtinTK_and_tong_sotien_thanhtoan_and_tong_so_taikhoan_tietkiem() {
        return tkTTRepository.thongtinTK_and_tong_sotien_thanhtoan_and_tong_so_taikhoan_tietkiem();
    }

}
