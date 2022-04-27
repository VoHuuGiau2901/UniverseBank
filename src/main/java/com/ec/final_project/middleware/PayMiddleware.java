package com.ec.final_project.middleware;

import com.ec.final_project.Beans.lichsugiaodich;
import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Services.Services.lichsugiaodichService;
import com.ec.final_project.Services.Services.taikhoan_thanhtoanService;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class PayMiddleware {
    @Autowired
    private taikhoan_thanhtoanService tkTTService;

    @Autowired
    private taikhoan_tietkiemService tkTKService;

    @Autowired
    private lichsugiaodichService lsGDService;

    public void update_payAccount(double m, int id) {
        tkTTService.Update(m, id);
    }

    public void create_trans_history(lichsugiaodich lsGD) {
        lsGDService.Create(lsGD);
    }

    public void Cancel_Saving(int id){
        tkTKService.Cancel_Saving(id);
    }

    public List<lichsugiaodich> getAll_trans(){
        return lsGDService.getAll();
    }
}
