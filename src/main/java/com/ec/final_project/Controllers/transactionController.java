package com.ec.final_project.Controllers;

import com.ec.final_project.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/UserArea")
@CrossOrigin
public class transactionController {

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @PostMapping("/Deposite")
    public String naptien(@RequestBody Map<String, String> json) {
        String date=json.get("ngaygui");
        tkTKService.updatetkTK(Integer.parseInt(json.get("acc_id")),Integer.parseInt(json.get("sotien")), date);
        return "money transfer completed";
    }
}
