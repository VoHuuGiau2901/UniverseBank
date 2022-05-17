package com.ec.final_project.Services.Services;

import java.util.List;

public interface pay_accountService {
    void Create(double sotien,String sotaikhoan,int acc_id);
    void Update(double sotien,int acc_id);
    List<Object> getAll();
}
