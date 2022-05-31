package com.ec.final_project.Services.Services;

import com.ec.final_project.Entity.pay_account;

import java.util.List;

public interface pay_accountService {
    void Create(double sotien,String sotaikhoan,int acc_id);
    void Update(double sotien,int acc_id);
    List<Object> getAll();
}
