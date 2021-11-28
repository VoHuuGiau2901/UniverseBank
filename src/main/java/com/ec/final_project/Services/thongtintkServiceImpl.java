package com.ec.final_project.Services;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Repositories.thongtintkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class thongtintkServiceImpl implements thongtintkService {

    @Autowired
    private thongtintkRepository tkRepository;

    @Override
    public thongtintk kiemtratk(thongtintk tk) {
        return tkRepository.checktaikhoanExists(tk.getTaikhoan());
    }

    @Override
    public void savethongtintk(thongtintk tk) {
        tkRepository.saveAndFlush(tk);
    }

    @Override
    public thongtintk timthongtin(thongtintk tk) {
        return tkRepository.findBytaikhoanANDmatkhau(tk.getTaikhoan(), tk.getMatkhau());
    }

    @Override
    public List<thongtintk> getAlltk() {
        return tkRepository.findAll();
    }

    @Override
    public Optional<thongtintk> findbyID(int id) {
        return tkRepository.findById(id);
    }

    @Override
    public int getMaxID() {
        return tkRepository.getMaxID();
    }
}
