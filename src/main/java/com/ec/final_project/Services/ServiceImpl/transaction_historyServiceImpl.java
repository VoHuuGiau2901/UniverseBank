package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.transaction_history;
import com.ec.final_project.Repositories.transaction_historyRepository;
import com.ec.final_project.Services.Services.transaction_hisotryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class transaction_historyServiceImpl implements transaction_hisotryService {

    private final transaction_historyRepository trans_history_repo;

    @Autowired
    public transaction_historyServiceImpl(transaction_historyRepository trans_history_repo) {
        this.trans_history_repo = trans_history_repo;
    }

    @Override
    public List<transaction_history> getAll(int acc_id) {
        return trans_history_repo.getAll_lsGDByID(acc_id);
    }

    @Override
    public void Create(transaction_history lsGD) {
        trans_history_repo.saveAndFlush(lsGD);
    }
}
