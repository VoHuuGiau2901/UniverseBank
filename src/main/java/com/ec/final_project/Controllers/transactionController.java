package com.ec.final_project.Controllers;

import com.ec.final_project.Entity.transaction_history;
import com.ec.final_project.Entity.saving_account;
import com.ec.final_project.Services.Services.transaction_hisotryService;
import com.ec.final_project.Services.Services.pay_accountService;
import com.ec.final_project.Services.Services.saving_accountService;
import com.ec.final_project.Utils.ControllerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/Welcome/UserArea")
@CrossOrigin
public class transactionController {

    @Autowired
    private saving_accountService saving_Acc_Service;

    @Autowired
    private pay_accountService pay_Acc_Service;

    @Autowired
    private transaction_hisotryService trans_His_Service;

    @PostMapping("/Deposit")
    public String Deposit(@RequestBody Map<String, String> req) {
        pay_Acc_Service.Update(Double.parseDouble(req.get("money")), Integer.parseInt(req.get("acc_id")));
        transaction_history lsGD = new transaction_history(ControllerUtils.getCurrentDate(), Double.parseDouble(req.get("money")), 1, Integer.parseInt(req.get("acc_id")));
        trans_His_Service.Create(lsGD);
        return "Money transfer completed";
    }

    @PostMapping("/SaveMoney")
    public String SaveMoney(@RequestBody saving_account tkTK) {
        saving_Acc_Service.Create(tkTK);
        pay_Acc_Service.Update(-tkTK.getDeposit(), tkTK.getAcc_id());
        transaction_history lsGD = new transaction_history(ControllerUtils.getCurrentDate(), tkTK.getDeposit(), 3, tkTK.getAcc_id());
        trans_His_Service.Create(lsGD);
        return "Save money complete";
    }

    @PostMapping("/Withdraw")
    public String Withdraw(@RequestBody Map<String, String> req) {
        pay_Acc_Service.Update(-Double.parseDouble(req.get("withdrawMoney")), Integer.parseInt(req.get("acc_id")));
        transaction_history lsGD = new transaction_history(ControllerUtils.getCurrentDate(), Double.parseDouble(req.get("withdrawMoney")), 2, Integer.parseInt(req.get("acc_id")));
        trans_His_Service.Create(lsGD);
        return "Money transfer completed";
    }

    @PostMapping("/CheckMy_Saving_Acc")
    public List<saving_account> xem_tk_TK(@RequestBody Map<String, String> req) {
        return saving_Acc_Service.getAllByAcc_id(Integer.parseInt(req.get("userID")));
    }

    @PostMapping("/Cancel_Saving")
    public String cancel(@RequestBody Map<String, String> req) {
        saving_Acc_Service.Cancel_Saving(Integer.parseInt(req.get("id")));
        return "cancel success";
    }

    @PostMapping("/Withdraw_Saving_Acc")
    public String Withdraw_Saving_Acc(@RequestBody Map<String, String> req) {
        saving_Acc_Service.Update(Integer.parseInt(req.get("id")), Integer.parseInt(req.get("amount")));
        return "finished";
    }

    @PostMapping("/My_Transaction_History")
    public List<transaction_history> get_history(@RequestBody Map<String, String> req) {
        return trans_His_Service.getAll(Integer.parseInt(req.get("acc_id")));
    }
}
