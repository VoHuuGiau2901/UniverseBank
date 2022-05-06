package com.ec.final_project.Services.Services;

import com.ec.final_project.Entity.account;

import java.util.List;

public interface accountService {
    boolean CheckExist(account tk);
    void Create(account tk);
    List<account> getAll();
    void delete_Acc(int id);
}
