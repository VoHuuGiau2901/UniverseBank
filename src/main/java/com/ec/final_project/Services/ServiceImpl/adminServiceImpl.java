package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Repositories.lichsugiaodichRepository;
import com.ec.final_project.Services.Services.adminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class adminServiceImpl implements adminService {

    @Autowired
    private lichsugiaodichRepository lsGDRepository;

    @Override
    public List<Object> getFlucts() {
        return lsGDRepository.getFlucts();
    }

    @Override
    public Object getAllCustomer() {
        return null;
    }
}
