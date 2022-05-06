package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.transaction_history;
import com.ec.final_project.Repositories.transaction_historyRepository;
import com.ec.final_project.Services.Services.transaction_hisotryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transaction_historyServiceImpl implements transaction_hisotryService {

    @Autowired
    private transaction_historyRepository lsGDRepository;

    @Override
    public List<transaction_history> getAll() {
        return lsGDRepository.getAll_lsGD();
    }

    @Override
    public void Create(transaction_history lsGD) {
        lsGDRepository.saveAndFlush(lsGD);
    }
}
