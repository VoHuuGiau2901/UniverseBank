package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.pay_account;
import com.ec.final_project.Repositories.pay_accountRepository;
import com.ec.final_project.Services.Services.pay_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class pay_accountServiceImpl implements pay_accountService {

    private final pay_accountRepository pay_acc_repo;
    @Autowired
    public pay_accountServiceImpl(pay_accountRepository pay_acc_repo) {
        this.pay_acc_repo = pay_acc_repo;
    }

    @Override
    public void Create(double sotien, String sotaikhoan, int acc_id) {
        pay_acc_repo.addtkTT(sotien,sotaikhoan,acc_id);
    }

    @Override
    public void Update(double sotien, int acc_id) {
        pay_acc_repo.Update(sotien,acc_id);
    }

    @Override
    public List<Object> getAll() {
        return pay_acc_repo.getAll();
    }

}
