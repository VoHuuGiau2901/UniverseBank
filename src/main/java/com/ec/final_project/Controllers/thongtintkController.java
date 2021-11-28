package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.taikhoan_tietkiemService;
import com.ec.final_project.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
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
            int max_id=tkService.getMaxID();
            tkTKService.addtkTK(0,"129120",max_id);
            return "new account added";
        }
    }

    @GetMapping("/Login")
    public List<thongtintk> logIn() {
            return tkService.getAlltk();
    }

//    @GetMapping("/userArea")
//    public List<taikhoan_tietkiem> get(){
//        return tkTKService.getAll();
//    }

    @GetMapping("/userArea")
    public List<Object> get(){
        return tkTKService.get_thongtintk_join_taikhoan_tietkiem();
    }
}
