package com.ec.final_project.Services.ServiceImpl;

import com.ec.final_project.Beans.lichsugiaodich;
import com.ec.final_project.Repositories.lichsugiaodichRepository;
import com.ec.final_project.Services.Services.lichsugiaodichService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class lichsugiaodichServiceImpl implements lichsugiaodichService {

    @Autowired
    private lichsugiaodichRepository lsGDRepository;

    @Override
    public List<lichsugiaodich> getAll() {
        return lsGDRepository.getAll_lsGD();
    }

    @Override
    public void Create(lichsugiaodich lsGD) {
        lsGDRepository.saveAndFlush(lsGD);
    }
}
