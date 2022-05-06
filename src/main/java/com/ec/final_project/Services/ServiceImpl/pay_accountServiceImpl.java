package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Repositories.pay_accountRepository;
import com.ec.final_project.Services.Services.pay_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pay_accountServiceImpl implements pay_accountService {

    @Autowired
    private pay_accountRepository tkTTRepository;

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
