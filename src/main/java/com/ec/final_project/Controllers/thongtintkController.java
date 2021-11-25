package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class thongtintkController {

    @Autowired
    private thongtintkService tkService;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk){
        tkService.savethongtintk(tk);
        return "new account added";
    }

    @PostMapping("/Login")
    public String logIn (@RequestBody thongtintk tk){
        if (tkService.timthongtin(tk) != null) {
            return "login Successfully";
        }
        else return "login failed";
    }
}
