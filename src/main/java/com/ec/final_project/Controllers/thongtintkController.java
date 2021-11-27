package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class thongtintkController {

    @Autowired
    private thongtintkService tkService;

    @PostMapping("/Register") // gửi post ở /register tại /welcome thì hàm dưới chạy
    public String add(@RequestBody thongtintk tk) {
        if (tkService.kiemtratk(tk) != null) {
            return "account already taken";
        } else {
            tkService.savethongtintk(tk);
            return "new account added";
        }
    }

    @GetMapping("/Login") //chỉ cần truy cập vào /Login tại /welcome thif chạy
    public List<thongtintk> logIn() {
        return tkService.getAlltk();
    }

    @GetMapping("/userArea")
    public List<thongtintk> getDetail(){
        return tkService.getAlltk();
    }
}
