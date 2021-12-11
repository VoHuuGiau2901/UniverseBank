package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.taikhoan_tietkiemService;
import com.ec.final_project.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class thongtintkController {

    @Autowired
    private thongtintkService tkService;

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk) {
        if (tkService.kiemtratk(tk) != null) {
            return "account already taken";
        } else {
            tkService.savethongtintk(tk);
//            tkTKService.addtkTK(0, tk.getSdt(), tk.getAcc_id());
            tkTTService.addtkTT(0,tk.getSdt(),tk.getAcc_id());
            return "new account added";
        }
    }

    @GetMapping("/Login")
    public List<thongtintk> logIn() {
        return tkService.getAlltk();
    }

    @GetMapping("/userArea")
    public List<Object> get() {
        return tkTKService.get_thongtintk_join_taikhoan_tietkiem_join_taikhoan_thanhtoan();
    }
}
