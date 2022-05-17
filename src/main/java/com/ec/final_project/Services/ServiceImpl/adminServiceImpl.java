package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Entity.admin;
import com.ec.final_project.Repositories.adminRepository;
import com.ec.final_project.Repositories.transaction_historyRepository;
import com.ec.final_project.Services.Services.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements adminService {

    private final transaction_historyRepository trans_history_repo;
    private final adminRepository admin_repo;

    @Autowired
    public adminServiceImpl(transaction_historyRepository trans_history_repo, adminRepository admin_repo) {
        this.trans_history_repo = trans_history_repo;
        this.admin_repo = admin_repo;
    }

    @Override
    public List<Object> getFluctuates() {
        return trans_history_repo.getFluctuates();
    }

    @Override
    public admin validate(String username, String password) {
        return admin_repo.validate(username, password);
    }

    @Override
    public Object getAllCustomer() {
        return null;
    }
}
