package com.ec.final_project.Services.Services;

import com.ec.final_project.Beans.laisuat;
import com.ec.final_project.Beans.lichsugiaodich;

import java.util.List;

public interface lichsugiaodichService {
    List<lichsugiaodich> getAll();
    void Create(lichsugiaodich lsGD);
}
