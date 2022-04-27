package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.laisuat;
import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.Services.*;
import com.ec.final_project.middleware.AdminMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/Administrator")
@CrossOrigin
public class AdminController {
    AdminMiddleware adminMiddleware;

    @GetMapping("/AllUserStatus")
    public Object GetAllUser_Status() {
        return adminMiddleware.getAllCustomer();
    }

    @GetMapping("/Stonk_Per_Period")
    public List<Object> getChanges() {
        return adminMiddleware.getFlucts();
    }

    @PostMapping("/All_Saving_Account")
    public List<taikhoan_tietkiem> getall() {
        return adminMiddleware.getAll_savingAccount();
    }

    @GetMapping("/AllCustomers_And_their_Pay_money")
    public List<Object> thongtinTK_and_sotien_thanhtoan() {
        return adminMiddleware.getAll_payAccount();
    }

    @GetMapping("/All_laisuat")
    public List<laisuat> getAll_laiSuat() {
        return adminMiddleware.getAll_laisuat();
    }

    @PostMapping("/Change_laisuat")
    public String change(@RequestBody Map<String, String> json) {
        float l, k;
        k = Float.parseFloat(json.get("kyhan"));
        l = Float.parseFloat(json.get("laisuat")) / 1200 * k;
        adminMiddleware.Update_laisuat(l, json.get("kyhan"));
        return "change complete";
    }
}
