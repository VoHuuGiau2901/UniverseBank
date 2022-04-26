package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Repositories.taikhoan_thanhtoanRepository;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taikhoan_thanhtoanServiceImpl implements taikhoan_thanhtoanService {

    @Autowired
    private taikhoan_thanhtoanRepository tkTTRepository;

    @Override
    public void Create(double sotien, String sotaikhoan, int acc_id) {
        tkTTRepository.addtkTT(sotien,sotaikhoan,acc_id);
    }

    @Override
    public void Update(double sotien, int acc_id) {
        tkTTRepository.Update(sotien,acc_id);
    }

    @Override
    public List<Object> getAll() {
        return tkTTRepository.getAll();
    }

}
