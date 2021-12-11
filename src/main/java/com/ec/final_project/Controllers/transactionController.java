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
        tkTTService.updatetkTT_AfterCreate_tkTK(tkTK.getSotien(),tkTK.getAcc_id());
        return "cc";
    }
}
