package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import com.ec.final_project.Services.Services.thongtintkService;
import com.ec.final_project.middleware.AccountMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class thongtintkController {

    AccountMiddleware accountMiddleware;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk) {
        if (accountMiddleware.CheckExist(tk) != null) {
            return "account already taken";
        } else {
            accountMiddleware.Create_New_Account(tk);
            accountMiddleware.Create_New_Pay_Account(tk);
            return "new account added";
        }
    }

    @GetMapping("/Login")
    public List<thongtintk> logIn() {
        return accountMiddleware.getAll_Account();
    }

    @GetMapping("/UserArea")
    public List<Object> get() {
        return accountMiddleware.getAccount();
    }
}
