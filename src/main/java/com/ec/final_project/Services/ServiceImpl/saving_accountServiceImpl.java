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
    private saving_accountRepository tkTKRepository;

    @Override
    public List<saving_account> getAll() {
        return tkTKRepository.getAll();
    }

    @Override
    public List<saving_account> getAllByAcc_id(int id) {
        return tkTKRepository.getAllByAcc_id(id);
    }

    @Override
    public void Create(saving_account tkTK) {
        tkTKRepository.saveAndFlush(tkTK);
    }

    @Override
    public Object getAccount(String username) {
        return tkTKRepository.getAccount(username);
    }

    @Override
    public void Cancel_Saving(int id) {
        tkTKRepository.Cancel_Saving(id);
        tkTKRepository.deleteById(id);
    }

    @Override
    public void check() {
        tkTKRepository.check();
    }
}
