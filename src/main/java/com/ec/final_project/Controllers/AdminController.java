package com.ec.final_project.Controllers;

import com.ec.final_project.Entity.interest_rate;
import com.ec.final_project.Entity.saving_account;
import com.ec.final_project.Services.Services.adminService;
import com.ec.final_project.Services.Services.interest_rateService;
import com.ec.final_project.Services.Services.pay_accountService;
import com.ec.final_project.Services.Services.saving_accountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/Administrator")
@CrossOrigin
public class AdminController {

    @Autowired
    private pay_accountService pay_Acc_Service;

    @Autowired
    private saving_accountService saving_Acc_Service;

    @Autowired
    private interest_rateService IR_Service;

    @Autowired
    private adminService Admin_Service;

    @GetMapping("/AllUserStatus")
    public Object GetAllUser_Status() {
        return Admin_Service.getAllCustomer();
    }

    @GetMapping("/Profit_Per_Period")
    public List<Object> getChanges() {
        return Admin_Service.getFlucts();
    }

    @PostMapping("/All_Saving_Account")
    public List<saving_account> getAll() {
        return saving_Acc_Service.getAll();
    }

    @GetMapping("/AllCustomers_And_their_Pay_money")
    public List<Object> thongtinTK_and_sotien_thanhtoan() {
        return pay_Acc_Service.getAll();
    }

    @GetMapping("/All_interestRate")
    public List<interest_rate> getAll_laiSuat() {
        return IR_Service.getAll();
    }

    @PostMapping("/Change_interestRate")
    public String change(@RequestBody Map<String, String> req) {
        float l, k;
        k = Float.parseFloat(req.get("period"));
        l = Float.parseFloat(req.get("interest_rate")) / 1200 * k;
        IR_Service.Update(l, req.get("period"));
        return "change complete";
    }
}
