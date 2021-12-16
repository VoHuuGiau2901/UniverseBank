package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.lichsugiaodichService;
import com.ec.final_project.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/Administrator")
@CrossOrigin
public class AdminController {
    @Autowired
    private lichsugiaodichService lsGDService;

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @GetMapping("/AllUserStatus")
    public Object GetAllUser_Status() {
        return lsGDService.get_total_user_and_money();
    }

    @GetMapping("/Stonk_Per_Period")
    public List<Object> Get_Stonk()  {
            return lsGDService.get_money_percent_stonk_per_period();
    }

    @PostMapping("/All_Saving_Account")
    public List<taikhoan_tietkiem> getall(@RequestBody Map<String, String> json){
        return tkTKService.getAll();
    }
}
