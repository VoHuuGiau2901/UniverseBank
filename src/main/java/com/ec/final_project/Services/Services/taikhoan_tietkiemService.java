package com.ec.final_project.Services.Services;

import com.ec.final_project.Beans.taikhoan_tietkiem;

import java.util.List;

public interface taikhoan_tietkiemService {
    List<taikhoan_tietkiem> getAll();
    List<taikhoan_tietkiem> getAllByAcc_id(int id);
    void Create(taikhoan_tietkiem tkTK);
    List<Object> getAccount();
    void Cancel_Saving(int id);
    void check();
}
