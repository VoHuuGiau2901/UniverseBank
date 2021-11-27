package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.taikhoan_tietkiemService;
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

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk) {
        if (tkService.kiemtratk(tk) != null) {
            return "account already taken";
        } else {
            tkService.savethongtintk(tk);
            return "new account added";
        }
    }

    @GetMapping("/Login")
    public List<thongtintk> logIn() {
            return tkService.getAlltk();
    }

    @GetMapping("/userArea")
    public List<taikhoan_tietkiem> get(){
        return tkTKService.getAll();
    }
}
