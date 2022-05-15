package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Repositories.transaction_historyRepository;
import com.ec.final_project.Services.Services.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements adminService {

    @Autowired
    private transaction_historyRepository trans_history_repo;

    @Override
    public List<Object> getFlucts() {
        return trans_history_repo.getFlucts();
    }

    @Override
    public Object getAllCustomer() {
        return null;
    }
}
