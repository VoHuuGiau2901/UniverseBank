package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Welcome")
@CrossOrigin
public class thongtintkController {

    @Autowired
    private thongtintkService tkService;

    @PostMapping("/Register")
    public String add(@RequestBody thongtintk tk) {
        if (tkService.kiemtratk(tk) != null) {
            return "account already taken";
        } else {
            tkService.savethongtintk(tk);
            return "new account added";
        }
    }
//    @RequestMapping(value = "/Login", method = RequestMethod.POST)
//    @ResponseBody
//    public String logIn(@RequestBody thongtintk tk) {
//        if (tkService.timthongtin(tk) != null) {
//            return tkService.timthongtin(tk);
//        } else return null;
//    }

    @RequestMapping("/Login")
    public thongtintk findAll(){
        return tkService.getalltk().get(0);
    }
}
