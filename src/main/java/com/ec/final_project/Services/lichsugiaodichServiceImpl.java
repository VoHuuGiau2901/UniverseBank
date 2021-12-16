package com.ec.final_project.Services;

import com.ec.final_project.Beans.lichsugiaodich;
import com.ec.final_project.Repositories.lichsugiaodichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class lichsugiaodichServiceImpl implements lichsugiaodichService{

    @Autowired
    private lichsugiaodichRepository lsGDRepository;

    @Override
    public void addNew_GiaoDich(lichsugiaodich lsGD) {
        lsGDRepository.saveAndFlush(lsGD);
    }

    @Override
    public Object get_total_user_and_money() {
        return lsGDRepository.get_total_user_and_money();
    }
}
