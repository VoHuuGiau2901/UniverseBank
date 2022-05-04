package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import com.ec.final_project.Services.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class thongtintkController {

    @Autowired
    private thongtintkService Acc_Service;

    @Autowired
    private taikhoan_thanhtoanService pay_Acc_Service;

    @Autowired
    private taikhoan_tietkiemService saving_Acc_Service;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk) {
        if (Acc_Service.CheckExist(tk)) {
            return "account already taken";
        } else {
            Acc_Service.Create(tk);
            pay_Acc_Service.Create(0, tk.getTaikhoan(), tk.getAcc_id());
            return "new account added";
        }
    }

    @GetMapping("/Login")
    public List<thongtintk> logIn() {
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
