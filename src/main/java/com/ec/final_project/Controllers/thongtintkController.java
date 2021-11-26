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
    @GetMapping("/Login")
    public List<thongtintk> logIn(@RequestBody thongtintk tk) {
        if (tkService.timthongtin(tk) != null) {
            return tkService.getalltk();
        } else return null;
    }

//    @RequestMapping(value = "/Login", method = RequestMethod.GET)
//    public String findAll(@RequestBody thongtintk tk) {
//        if (tkService.timthongtin(tk) != null) {
//            int id = tkService.timthongtin(tk).getAcc_id();
//            return tkService.findbyID(id).toString();
//        } else return null;
//    }
}
