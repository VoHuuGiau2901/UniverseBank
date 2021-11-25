package com.ec.final_project.Services;

import com.ec.final_project.Beans.thongtintk;
import com.ec.final_project.Repositories.thongtintkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class thongtintkServiceImpl implements thongtintkService{

   @Autowired
   private thongtintkRepository tkRepository;
    @Override
    public thongtintk savethongtintk(thongtintk tk) {
        return tkRepository.saveAndFlush(tk);
    }
}
