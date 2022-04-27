package com.ec.final_project.Controllers;

import com.ec.final_project.Beans.lichsugiaodich;
import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.Services.lichsugiaodichService;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import com.ec.final_project.middleware.AccountMiddleware;
import com.ec.final_project.middleware.PayMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/UserArea")
@CrossOrigin
public class transactionController {

    PayMiddleware payMiddleware;
    AccountMiddleware accountMiddleware;

    @PostMapping("/Deposit")
    public String naptien(@RequestBody Map<String, String> json) {
        payMiddleware.update_payAccount(Double.parseDouble(json.get("sotien")), Integer.parseInt(json.get("acc_id")));
        lichsugiaodich lsGD = new lichsugiaodich(ControllerUtils.getCurrentDate(), Double.parseDouble(json.get("sotien")), 1, Integer.parseInt(json.get("acc_id")));
        payMiddleware.create_trans_history(lsGD);
        return "money transfer completed";
    }

    @PostMapping("/SaveMoney")
    public String guitietkiem(@RequestBody taikhoan_tietkiem tkTK) {
        accountMiddleware.create_new_savingAccount(tkTK);
        payMiddleware.update_payAccount(-tkTK.getSotien(), tkTK.getAcc_id());
        lichsugiaodich lsGD = new lichsugiaodich(ControllerUtils.getCurrentDate(), tkTK.getSotien(), 3, tkTK.getAcc_id());
        payMiddleware.create_trans_history(lsGD);
        return "save money complete";
    }

    @PostMapping("/Withdraw")
    public String ruttien(@RequestBody Map<String, String> json) {
        payMiddleware.update_payAccount(-Double.parseDouble(json.get("sotienrut")), Integer.parseInt(json.get("acc_id")));
        lichsugiaodich lsGD = new lichsugiaodich(ControllerUtils.getCurrentDate(), Double.parseDouble(json.get("sotienrut")), 2, Integer.parseInt(json.get("acc_id")));
        payMiddleware.create_trans_history(lsGD);
        return "money transfer completed";
    }

    @GetMapping("/CheckMy_Saving_tk")
    public List<taikhoan_tietkiem> xem_tk_TK() {
        return accountMiddleware.getAll_savingAccount();
    }

    @PostMapping("/Cancel_Saving")
    public String cancel(@RequestBody Map<String, String> json) {
        payMiddleware.Cancel_Saving(Integer.parseInt(json.get("id")));
        return "cancel success";
    }

    @GetMapping("/My_Transaction_History")
    public List<lichsugiaodich> get_history() {
        return payMiddleware.getAll_trans();
    }
}
