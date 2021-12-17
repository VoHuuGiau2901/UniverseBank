package com.ec.final_project.Services;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Repositories.thongtintkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class thongtintkServiceImpl implements thongtintkService {

    @Autowired
    private thongtintkRepository tkRepository;

    @Override
    public thongtintk kiemtratk(thongtintk tk) {
        return tkRepository.checktaikhoanExists(tk.getTaikhoan() ,tk.getSdt(),tk.getEmail(),tk.getSoCMND());
    }

    @Override
    public void savethongtintk(thongtintk tk) {
        tkRepository.saveAndFlush(tk);
    }

    @Override
    public List<thongtintk> getAlltk() {
        return tkRepository.findAll();
    }
}
