package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.interest_rate;
import com.ec.final_project.Repositories.interest_rateRepository;
import com.ec.final_project.Services.Services.interest_rateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class interest_rateServiceImpl implements interest_rateService {
    @Autowired
    private interest_rateRepository lsRepository;

    @Override
    public List<interest_rate> getAll() {
        return lsRepository.findAll();
    }

    @Override
    public void Update(double l, String k) {
        lsRepository.Update(l, k);
    }

    @Override
    public void Insert_First(double l, String k) {
        lsRepository.Insert_First(l, k);
    }
}
