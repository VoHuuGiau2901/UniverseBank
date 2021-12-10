package com.ec.final_project.Services;

import com.ec.final_project.Repositories.taikhoan_thanhtoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class taikhoan_thanhtoanServiceImpl implements taikhoan_thanhtoanService {

    @Autowired
    private taikhoan_thanhtoanRepository tkTTRepository;

    @Override
    public void addtkTT(int sotien, String sotaikhoan, int acc_id) {
        tkTTRepository.addtkTT(sotien,sotaikhoan,acc_id);
    }
}
