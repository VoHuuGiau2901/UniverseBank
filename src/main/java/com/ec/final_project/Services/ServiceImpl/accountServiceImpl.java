package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.useraccount;
import com.ec.final_project.Repositories.accountRepository;
import com.ec.final_project.Services.Services.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class accountServiceImpl implements accountService {

    private final accountRepository acc_repo;

    @Autowired
    public accountServiceImpl(accountRepository acc_repo) {
        this.acc_repo = acc_repo;
    }

    @Override
    public boolean CheckExist(useraccount tk) {
        return acc_repo.checkExists(tk.getUsername(), tk.getPhone(), tk.getEmail(), tk.getIdentity_number()) != null;
    }

    @Override
    public void Create(useraccount tk) {
        acc_repo.saveAndFlush(tk);
    }

    @Override
    public List<useraccount> getAll() {
        return acc_repo.findAll();
    }

    @Override
    public void delete_Acc(int id) {
        acc_repo.deleteById(id);
    }

    @Override
    public useraccount validate(String username, String password) {
        return acc_repo.validate(username, password);
    }

    @Override
    public useraccount FindByEmail(String email) {
        return acc_repo.FindByEmail(email);
    }

    @Override
    public useraccount findByIdentityNumber(String identityNumber) {
        return acc_repo.findByIdentityNumber(identityNumber);
    }

    @Override
    public void UpdatePassword(int acc_id, String newPassword) {
        acc_repo.UpdatePassword(acc_id, newPassword);
    }
}
