package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.useraccount;
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
    public boolean CheckExist(useraccount tk) {
        return tkRepository.checkExists(tk.getUsername(), tk.getPhone(), tk.getEmail(), tk.getIdentity_number()) != null;
    }

    @Override
    public void Create(useraccount tk) {
        tkRepository.saveAndFlush(tk);
    }

    @Override
    public List<useraccount> getAll() {
        return tkRepository.findAll();
    }

    @Override
    public void delete_Acc(int id) {
        tkRepository.deleteById(id);
    }

    @Override
    public useraccount validate(String username, String password) {
        return tkRepository.validate(username, password);
    }
}
