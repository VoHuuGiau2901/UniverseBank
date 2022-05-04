package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.lichsugiaodich;
import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.Services.lichsugiaodichService;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/UserArea")
@CrossOrigin
public class transactionController {

    @Autowired
    private taikhoan_tietkiemService saving_Acc_Service;

    @Autowired
    private  taikhoan_thanhtoanService pay_Acc_Service;

    @Autowired
    private lichsugiaodichService trans_His_Service;

    @PostMapping("/Deposit")
    public String naptien(@RequestBody Map<String, String> json) {
        pay_Acc_Service.Update(Double.parseDouble(json.get("sotien")), Integer.parseInt(json.get("acc_id")));
        lichsugiaodich lsGD = new lichsugiaodich(ControllerUtils.getCurrentDate(), Double.parseDouble(json.get("sotien")), 1, Integer.parseInt(json.get("acc_id")));
        trans_His_Service.Create(lsGD);
        return "money transfer completed";
    }

    @PostMapping("/SaveMoney")
    public String guitietkiem(@RequestBody taikhoan_tietkiem tkTK) {
        saving_Acc_Service.Create(tkTK);
        pay_Acc_Service.Update(-tkTK.getSotien(), tkTK.getAcc_id());
        lichsugiaodich lsGD = new lichsugiaodich(ControllerUtils.getCurrentDate(), tkTK.getSotien(), 3, tkTK.getAcc_id());
        trans_His_Service.Create(lsGD);
        return "save money complete";
    }

    @PostMapping("/Withdraw")
    public String ruttien(@RequestBody Map<String, String> json) {
        pay_Acc_Service.Update(-Double.parseDouble(json.get("sotienrut")), Integer.parseInt(json.get("acc_id")));
        lichsugiaodich lsGD = new lichsugiaodich(ControllerUtils.getCurrentDate(), Double.parseDouble(json.get("sotienrut")), 2, Integer.parseInt(json.get("acc_id")));
        trans_His_Service.Create(lsGD);
        return "money transfer completed";
    }

    @GetMapping("/CheckMy_Saving_tk")
    public List<taikhoan_tietkiem> xem_tk_TK() {
        return saving_Acc_Service.getAll();
    }

    @PostMapping("/Cancel_Saving")
    public String cancel(@RequestBody Map<String, String> json) {
        saving_Acc_Service.Cancel_Saving(Integer.parseInt(json.get("id")));
        return "cancel success";
    }

    @GetMapping("/My_Transaction_History")
    public List<lichsugiaodich> get_history() {
        return trans_His_Service.getAll();
    }
}
