package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.lichsugiaodich;
import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.lichsugiaodichService;
import com.ec.final_project.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/UserArea")
@CrossOrigin
public class transactionController {

    private Date getCurrentDate() {
        return new Date(Calendar.getInstance().getTime().getTime());
    }

    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @Autowired
    private lichsugiaodichService lsGDService;

    @PostMapping("/Deposit")
    public String naptien(@RequestBody Map<String, String> json) {
        tkTTService.updatetkTT(Double.parseDouble(json.get("sotien")), Integer.parseInt(json.get("acc_id")));
        lichsugiaodich lsGD = new lichsugiaodich(getCurrentDate(), Double.parseDouble(json.get("sotien")), 1, Integer.parseInt(json.get("acc_id")));
        lsGDService.addNew_GiaoDich(lsGD);
        return "money transfer completed";
    }

    @PostMapping("/SaveMoney")
    public String guitietkiem(@RequestBody taikhoan_tietkiem tkTK) {
        tkTKService.addtkTK(tkTK);
        tkTTService.updatetkTT_AfterCreate_tkTK(tkTK.getSotien(), tkTK.getAcc_id());
        return "cc";
    }

    @PostMapping("/Withdraw")
    public String ruttien(@RequestBody Map<String, String> json) {
        tkTTService.updatetkTT_After_Withdraw(Double.parseDouble(json.get("sotienrut")), Integer.parseInt(json.get("acc_id")));
        lichsugiaodich lsGD = new lichsugiaodich(getCurrentDate(), Double.parseDouble(json.get("sotienrut")), 2, Integer.parseInt(json.get("acc_id")));
        lsGDService.addNew_GiaoDich(lsGD);
        return "money transfer completed";
    }

//    @PostMapping("/CheckMy_Saving_tk")
//    public List<taikhoan_tietkiem> xem_tk_TK(@RequestBody Map<String, String> json) {
//        int id = Integer.parseInt(json.get("acc_id"));
//        return tkTKService.getAllByAcc_id(id);
//    }

    @GetMapping("/CheckMy_Saving_tk")
    public List<taikhoan_tietkiem> xem_tk_TK() {
        return tkTKService.getAll();
    }

    @PostMapping("/Cancel_Saving")
    public String cancel(@RequestBody Map<String, String> json){
        tkTKService.cancel_saving(Integer.parseInt(json.get("id")));
        return "cancel success";
    }
}
