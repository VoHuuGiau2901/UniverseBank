package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.lichsugiaodichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Welcome/Administrator")
@CrossOrigin
public class AdminController {
    @Autowired
    private lichsugiaodichService lsGDService;

    @GetMapping("/AllUserStatus")
    public Object logIn() {
        return lsGDService.get_total_user_and_money();
    }
}
