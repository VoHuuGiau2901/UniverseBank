package com.ec.final_project.Controllers;

import com.ec.final_project.Entity.useraccount;
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
    public String add(@RequestBody useraccount tk) {
        if (Acc_Service.CheckExist(tk)) {
            return "account already taken";
        } else {
            Acc_Service.Create(tk);
            pay_Acc_Service.Create(0, tk.getPhone(), tk.getAcc_id());
            return "new account added";
        }
    }

    @PostMapping("/Login")
    public int login(@RequestBody Map<String, String> req) {
        String username = req.get("username");
        String password = req.get("password");

        if (Acc_Service.validate(username, password) != null) {
            return Acc_Service.validate(username, password).getAcc_id();
        } else return -1;
    }

    @PostMapping("/UserArea")
    public Object get(@RequestBody Map<String, String> req) {
        return saving_Acc_Service.getAccount(Integer.parseInt(req.get("userID")));
    }

    @PostMapping("/Forget_Password")
    public Object Forget_Password(@RequestBody Map<String, String> req) {
        useraccount acc = Acc_Service.FindByEmail(String.valueOf(req.get("email")));
        if (acc != null) {
            Random r = new Random();
            int verify_code = r.nextInt(999999);
            HashMap<String, String> res = new HashMap<>();
            res.put("verify_code", String.format("%06d", verify_code));
            res.put("acc_id", String.valueOf(acc.getAcc_id()));
            return res;
        } else {
            return "error";
        }
    }

    @PostMapping("/Renew_Password")
    public String Renew_Password(@RequestBody Map<String, String> req) {
        int acc_id = Integer.parseInt(req.get("acc_id"));
        String new_password = req.get("new_password");
        Acc_Service.UpdatePassword(acc_id, new_password);
        return "success";
    }

    @GetMapping("/Delete_Acc")
    public void delete_Acc(@RequestBody Map<String, String> req) {
        Acc_Service.delete_Acc(Integer.parseInt(req.get("id")));
    }
}
