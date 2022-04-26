package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class thongtintkController {

    @Autowired
    private com.ec.final_project.Services.Services.thongtintkService tkService;

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk) {
        if (tkService.CheckExist(tk) != null) {
            return "account already taken";
        } else {
            System.out.println("cc");
            tkService.Create(tk);
            tkTTService.Create(0,tk.getSdt(),tk.getAcc_id());
            return "new account added";
        }
    }

    @GetMapping("/Login")
    public List<thongtintk> logIn() {
        return tkService.getAll();
    }

    @GetMapping("/UserArea")
    public List<Object> get() {
        return tkTKService.getAccount();
    }
}
