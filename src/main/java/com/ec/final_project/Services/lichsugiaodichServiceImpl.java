package com.ec.final_project.Services;

import com.ec.final_project.Beans.lichsugiaodich;
import com.ec.final_project.Repositories.lichsugiaodichRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class lichsugiaodichServiceImpl implements lichsugiaodichService{

    @Autowired
    private lichsugiaodichRepository lsGDRepository;

    @Override
    public List<lichsugiaodich> getAll() {
        return lsGDRepository.findAll();
    }

    @Override
    public void addNew_GiaoDich(lichsugiaodich lsGD) {
        lsGDRepository.saveAndFlush(lsGD);
    }

    @Override
    public List<Object> get_money_percent_stonk_per_period() {
        return lsGDRepository.get_money_percent_stonk_per_period();
    }

    @Override
    public Object get_total_user_and_money() {
        return lsGDRepository.get_total_user_and_money();
    }


}
