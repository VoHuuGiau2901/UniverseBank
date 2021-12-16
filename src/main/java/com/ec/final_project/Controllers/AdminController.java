package com.ec.final_project.Controllers;

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
    public Object GetAllUser_Status() {
        return lsGDService.get_total_user_and_money();
    }

    @GetMapping("/Stonk_Per_Period")
    public List<Object> Get_Stonk()  {
            return lsGDService.get_money_percent_stonk_per_period();
    }
}
