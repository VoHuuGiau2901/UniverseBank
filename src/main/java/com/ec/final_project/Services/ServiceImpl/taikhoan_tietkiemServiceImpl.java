package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Beans.taikhoan_tietkiem;
import com.ec.final_project.Repositories.taikhoan_tietkiemRepository;
import com.ec.final_project.Services.Services.taikhoan_tietkiemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class taikhoan_tietkiemServiceImpl implements taikhoan_tietkiemService {
    @Autowired
    private taikhoan_tietkiemRepository tkTKRepository;

    @Override
    public List<taikhoan_tietkiem> getAll() {
        return tkTKRepository.getAll();
    }

    @Override
    public List<taikhoan_tietkiem> getAllByAcc_id(int id) {
        return tkTKRepository.getAllByAcc_id(id);
    }

    @Override
    public void Create(taikhoan_tietkiem tkTK) {
        tkTKRepository.saveAndFlush(tkTK);
    }

    @Override
    public List<Object> getAccount() {
        return tkTKRepository.getAccount();
    }

    @Override
    public void Cancel_Saving(int id) {
        tkTKRepository.Cancel_Saving(id);
        tkTKRepository.deleteById(id);
    }

    @Override
    public void check() {
        tkTKRepository.check();
    }
}
