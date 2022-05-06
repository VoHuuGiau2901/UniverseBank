package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.account;
import com.ec.final_project.Repositories.accountRepository;
import com.ec.final_project.Services.Services.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class accountServiceImpl implements accountService {

    @Autowired
    private accountRepository tkRepository;

    @Override
    public boolean CheckExist(account tk) {
        return tkRepository.checktaikhoanExists(tk.getUsername(), tk.getPhone(), tk.getEmail(), tk.getIdentity_number()) != null;
    }

    @Override
    public void Create(account tk) {
        tkRepository.saveAndFlush(tk);
    }

    @Override
    public List<account> getAll() {
        return tkRepository.findAll();
    }

    @Override
    public void delete_Acc(int id) {
        tkRepository.deleteById(id);
    }
}
