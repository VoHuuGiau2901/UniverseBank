package com.ec.final_project.Controllers;

import com.ec.final_project.Entity.account;
import com.ec.final_project.Services.ServiceImpl.accountServiceImpl;
import com.ec.final_project.Services.ServiceImpl.pay_accountServiceImpl;
import com.ec.final_project.Services.ServiceImpl.saving_accountServiceImpl;
import com.ec.final_project.Services.Services.pay_accountService;
import com.ec.final_project.Services.Services.saving_accountService;
import com.ec.final_project.Services.Services.accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class accountController {
    @Autowired
    private accountService Acc_Service;
    @Autowired
    private pay_accountService pay_Acc_Service;
    @Autowired
    private saving_accountService saving_Acc_Service;

    @PostMapping("/Register")
    public String add(@RequestBody account tk) {
        if (Acc_Service.CheckExist(tk)) {
            return "account already taken";
        } else {
            Acc_Service.Create(tk);
            pay_Acc_Service.Create(0, tk.getUsername(), tk.getAcc_id());
            return "new account added";
        }
    }

    @GetMapping("/Login")
    public List<account> logIn() {
        return Acc_Service.getAll();
    }

    @GetMapping("/UserArea")
    public List<Object> get() {
        return saving_Acc_Service.getAccount();
    }

    @GetMapping("/Delete_Acc")
    public void delete_Acc(@RequestBody Map<String, String> json) {
        Acc_Service.delete_Acc(Integer.parseInt(json.get("id")));
    }
}
