package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Beans.laisuat;
import com.ec.final_project.Repositories.laisuatRepository;
import com.ec.final_project.Services.Services.laisuatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class laisuatServiceImpl implements laisuatService {
    @Autowired
    private laisuatRepository lsRepository;

    @Override
    public List<laisuat> getAll() {
        return lsRepository.findAll();
    }

    @Override
    public void Update(float l, String k) {
        lsRepository.Update(l,k);
    }
}
