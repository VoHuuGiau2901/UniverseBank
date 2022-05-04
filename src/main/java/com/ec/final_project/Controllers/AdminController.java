package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.laisuat;
import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.Services.adminService;
import com.ec.final_project.Services.Services.laisuatService;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/Administrator")
@CrossOrigin
public class AdminController {

    @Autowired
    private taikhoan_thanhtoanService pay_Acc_Service;

    @Autowired
    private taikhoan_tietkiemService saving_Acc_Service;

    @Autowired
    private laisuatService IR_Service;

    @Autowired
    private adminService Admin_Service;

    @GetMapping("/AllUserStatus")
    public Object GetAllUser_Status() {
        return Admin_Service.getAllCustomer();
    }

    @GetMapping("/Stonk_Per_Period")
    public List<Object> getChanges() {
        return Admin_Service.getFlucts();
    }

    @PostMapping("/All_Saving_Account")
    public List<taikhoan_tietkiem> getall() {
        return saving_Acc_Service.getAll();
    }

    @GetMapping("/AllCustomers_And_their_Pay_money")
    public List<Object> thongtinTK_and_sotien_thanhtoan() {
        return pay_Acc_Service.getAll();
    }

    @GetMapping("/All_laisuat")
    public List<laisuat> getAll_laiSuat() {
        return IR_Service.getAll();
    }

    @PostMapping("/Change_laisuat")
    public String change(@RequestBody Map<String, String> json) {
        float l, k;
        k = Float.parseFloat(json.get("kyhan"));
        l = Float.parseFloat(json.get("laisuat")) / 1200 * k;
        IR_Service.Update(l, json.get("kyhan"));
        return "change complete";
    }
}
