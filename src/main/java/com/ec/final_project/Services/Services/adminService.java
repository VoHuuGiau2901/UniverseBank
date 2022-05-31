package com.ec.final_project.Services.Services;

import com.ec.final_project.Entity.admin;
import com.ec.final_project.Entity.useraccount;

import java.util.List;

public interface adminService {
    Object getAllCustomer();
    List<Object> getProfit();
    admin validate(String username, String password);
}
