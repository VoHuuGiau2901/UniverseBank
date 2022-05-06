package com.ec.final_project.Controllers;

import com.ec.final_project.Entity.useraccount;
import com.ec.final_project.Services.Services.pay_accountService;
import com.ec.final_project.Services.Services.saving_accountService;
import com.ec.final_project.Services.Services.accountService;
import com.fasterxml.jackson.annotation.JsonValue;
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
    public String add(@RequestBody useraccount tk) {
        if (Acc_Service.CheckExist(tk)) {
            return "account already taken";
        } else {
            Acc_Service.Create(tk);
            pay_Acc_Service.Create(0, tk.getUsername(), tk.getAcc_id());
            return "new account added";
        }
    }

//    @GetMapping("/Login")
//    public List<account> logIn() {
//        return Acc_Service.getAll();
//    }

    @PostMapping("/Login")
    public Object login(@RequestBody Map<String, String> json){
        String username=json.get("username");
        String password=json.get("password");

        if(Acc_Service.validate(username,password)!=null){
            return saving_Acc_Service.getAccount(username);
        }else return "error";
    }

//    @GetMapping("/UserArea")
//    public List<Object> get(@RequestBody Map<String, String> json) {
//        return saving_Acc_Service.getAccount(json.get("username"));
//    }

    @GetMapping("/Delete_Acc")
    public void delete_Acc(@RequestBody Map<String, String> json) {
        Acc_Service.delete_Acc(Integer.parseInt(json.get("id")));
    }
}
