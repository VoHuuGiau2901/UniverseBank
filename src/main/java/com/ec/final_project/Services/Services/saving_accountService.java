package com.ec.final_project.Services.Services;

import com.ec.final_project.Entity.saving_account;

import java.util.List;

public interface saving_accountService {
    List<saving_account> getAll();

    List<saving_account> getAllByAcc_id(int id);

    void Create(saving_account tkTK);

    Object getAccount(int acc_id);

    void Cancel_Saving(int id);

    void Update(int id, int amount);

    void check();
}
