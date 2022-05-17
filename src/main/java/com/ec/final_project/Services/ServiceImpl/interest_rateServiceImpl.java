package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.interest_rate;
import com.ec.final_project.Repositories.interest_rateRepository;
import com.ec.final_project.Services.Services.interest_rateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class interest_rateServiceImpl implements interest_rateService {
    private final interest_rateRepository interest_repo;

    @Autowired
    public interest_rateServiceImpl(interest_rateRepository interest_repo) {
        this.interest_repo = interest_repo;
    }

    @Override
    public List<interest_rate> getAll() {
        return interest_repo.findAll();
    }

    @Override
    public void Update(double l, String k) {
        interest_repo.Update(l, k);
    }

    @Override
    public void Insert_First(double l, String k) {
        interest_repo.Insert_First(l, k);
    }
}
