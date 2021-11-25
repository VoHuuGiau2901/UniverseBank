package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Welcome")
public class thongtintkController {

    @Autowired
    private thongtintkService tkService;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk){
        tkService.savethongtintk(tk);
        return "new account added";
    }
}
