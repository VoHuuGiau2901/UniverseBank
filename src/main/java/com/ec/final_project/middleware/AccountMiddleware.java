package com.ec.final_project.middleware;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import com.ec.final_project.Services.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AccountMiddleware {
    @Autowired
    private thongtintkService tkService;

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    public thongtintk CheckExist(thongtintk tk) {
        return tkService.CheckExist(tk);
    }

    public void Create_New_Account(thongtintk tk) {
        tkService.Create(tk);
    }

    public void Create_New_Pay_Account(thongtintk tk) {
        tkTTService.Create(0, tk.getSdt(), tk.getAcc_id());
    }

    public void create_new_savingAccount(taikhoan_tietkiem tktk) {
        tkTKService.Create(tktk);
    }

    public List<thongtintk> getAll_Account() {
        return tkService.getAll();
    }

    public List<Object> getAccount() {
        return tkTKService.getAccount();
    }

    public List<taikhoan_tietkiem> getAll_savingAccount(){
        return tkTKService.getAll();
    }
}
