package com.ec.final_project.Controllers;

import com.ec.final_project.Services.taikhoan_thanhtoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Welcome/UserArea")
@CrossOrigin
public class transactionController {
    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @PostMapping("/Deposit")
    public String naptien(@RequestBody Map<String, String> json) {
        tkTTService.updatetkTT(Integer.parseInt(json.get("sotien")),Integer.parseInt(json.get("acc_id")));
        return "money transfer completed";
    }
}
