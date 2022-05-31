package com.ec.final_project.Controllers;

import com.ec.final_project.Entity.useraccount;
import com.ec.final_project.Services.Services.pay_accountService;
import com.ec.final_project.Services.Services.saving_accountService;
import com.ec.final_project.Services.Services.accountService;
import com.ec.final_project.Utils.ControllerUtils;
import com.ec.final_project.Utils.MailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class accountController {
    private final accountService Acc_Service;
    private final pay_accountService pay_Acc_Service;
    private final saving_accountService saving_Acc_Service;

    @Autowired
    public accountController(accountService acc_Service, pay_accountService pay_Acc_Service, saving_accountService saving_Acc_Service) {
        Acc_Service = acc_Service;
        this.pay_Acc_Service = pay_Acc_Service;
        this.saving_Acc_Service = saving_Acc_Service;
    }

    @PostMapping("/Register")
    public Object Register(@RequestBody useraccount acc) {
        if (Acc_Service.CheckExist(acc)) {
            return "account already taken";
        } else {
            String verify_code = String.format("%06d", ControllerUtils.Get_OTP());
            MailSender.send(acc.getEmail(), "Verify Email Code", "Use this code to verify your account: " + verify_code);
            HashMap<String, String> res = new HashMap<>();
            res.put("verify_code", verify_code);
            return res;
        }
    }

    @PostMapping("/Register/CreateAccount")
    public Object CreateAccount(@RequestBody useraccount acc) {
        Acc_Service.Create(acc);
        pay_Acc_Service.Create(0, acc.getPhone(), acc.getAcc_id());
        return "new account added";
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
    public Object getAccount(@RequestBody Map<String, String> req) {
        return saving_Acc_Service.getAccount(Integer.parseInt(req.get("userID")));
    }

    @PostMapping("/Forget_Password")
    public Object Forget_Password(@RequestBody Map<String, String> req) {
        useraccount acc = Acc_Service.FindByEmail(String.valueOf(req.get("email")));
        if (acc != null) {
            int verify_code = ControllerUtils.Get_OTP();
            MailSender.send(acc.getEmail(), "Renew Password Code", "Use this code to verify your account: " + verify_code);
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
