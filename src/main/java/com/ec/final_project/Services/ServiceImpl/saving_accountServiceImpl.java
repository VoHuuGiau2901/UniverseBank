package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.saving_account;
import com.ec.final_project.Repositories.saving_accountRepository;
import com.ec.final_project.Services.Services.saving_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class saving_accountServiceImpl implements saving_accountService {
    @Autowired
    private saving_accountRepository saving_acc_repo;

    @Override
    public List<saving_account> getAll() {
        return saving_acc_repo.getAll();
    }

    @Override
    public List<saving_account> getAllByAcc_id(int id) {
        return saving_acc_repo.getAllByAcc_id(id);
    }

    @Override
    public void Create(saving_account tkTK) {
        saving_acc_repo.saveAndFlush(tkTK);
    }

    @Override
    public Object getAccount(int acc_id) {
        return saving_acc_repo.getAccount(acc_id);
    }

    @Override
    public void Cancel_Saving(int id) {
        saving_acc_repo.Cancel_Saving(id);
        saving_acc_repo.deleteById(id);
    }

    @Override
    public void Update(int id, int amount) {
        saving_acc_repo.Update(id, amount);
    }

    @Override
    public void check() {
        saving_acc_repo.check();
    }
}
