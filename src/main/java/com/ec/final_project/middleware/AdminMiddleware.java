package com.ec.final_project.middleware;

import com.ec.final_project.Beans.laisuat;
import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.Services.AdminService;
import com.ec.final_project.Services.Services.laisuatService;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class AdminMiddleware {
    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @Autowired
    private laisuatService lsService;

    @Autowired
    private AdminService adminService;

    public List<laisuat> getAll_laisuat() {
        return lsService.getAll();
    }

    public void Update_laisuat(float l, String k) {
        lsService.Update(l, String.valueOf(k));
    }

    public List<Object> getFlucts() {
        return adminService.getFlucts();
    }

    public List<Object> getAll_payAccount() {
        return tkTTService.getAll();
    }

    public List<taikhoan_tietkiem> getAll_savingAccount() {
        return tkTKService.getAll();
    }

    public Object getAllCustomer() {
        return adminService.getAllCustomer();
    }
}
