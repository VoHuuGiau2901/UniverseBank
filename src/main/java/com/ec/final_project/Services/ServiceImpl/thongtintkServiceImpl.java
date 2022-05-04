package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Repositories.thongtintkRepository;
import com.ec.final_project.Services.Services.thongtintkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class thongtintkServiceImpl implements thongtintkService {

    @Autowired
    private thongtintkRepository tkRepository;

    @Override
    public boolean CheckExist(thongtintk tk) {
        return tkRepository.checktaikhoanExists(tk.getTaikhoan(), tk.getSdt(), tk.getEmail(), tk.getSoCMND()) != null;
    }

    @Override
    public void Create(thongtintk tk) {
        tkRepository.saveAndFlush(tk);
    }

    @Override
    public List<thongtintk> getAll() {
        return tkRepository.findAll();
    }

    @Override
    public void delete_Acc(int id) {
        tkRepository.deleteById(id);
    }
}
