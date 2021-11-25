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
        return tkRepository.checktaikhoanExists(tk.getTaikhoan());
    }

    @Override
    public thongtintk savethongtintk(thongtintk tk) {
        return tkRepository.saveAndFlush(tk);
    }

    @Override
    public String timthongtin(thongtintk tk) {
        return tkRepository.findBytaikhoanANDmatkhau(tk.getTaikhoan(), tk.getMatkhau());
    }

    @Override
    public List<thongtintk> getalltk() {
        return tkRepository.findAll();
    }
}
