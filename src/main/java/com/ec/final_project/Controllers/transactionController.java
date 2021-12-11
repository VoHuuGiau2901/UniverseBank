package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/Welcome/UserArea")
@CrossOrigin
public class transactionController {
    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @PostMapping("/Deposit")
    public String naptien(@RequestBody Map<String, String> json) {
        tkTTService.updatetkTT(Double.parseDouble(json.get("sotien")),Integer.parseInt(json.get("acc_id")));
        return "money transfer completed";
    }

    @PostMapping("/SaveMoney")
    public String guitietkiem(@RequestBody taikhoan_tietkiem tkTK){
        tkTKService.addtkTK(tkTK);
//        System.out.println(json.get("sotien"));
//        System.out.println(json.get("ngaygui"));
//        System.out.println(json.get("ngaydaohan"));
//        System.out.println(json.get("tuychon"));
//        System.out.println(json.get("kyhan"));
//        System.out.println(json.get("acc_id"));
//        tkTKService.updatetkTK(Double.parseDouble(json.get("sotien")),json.get("ngaygui"),json.get("ngaydaohan"),json.get("tuychon"),json.get("kyhan"),Integer.parseInt(json.get("acc_id")));
        return "cc";
    }
}
