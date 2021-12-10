package com.ec.final_project.Controllers;

import com.ec.final_project.Services.taikhoan_thanhtoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/UserArea")
@CrossOrigin
public class transactionController {
    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @PostMapping("/Deposite")
    public String naptien(@RequestBody Map<String, String> json) {
        tkTTService.updatetkTT(Integer.parseInt(json.get("acc_id")),Integer.parseInt(json.get("sotien")));
        return "money transfer completed";
    }
}
