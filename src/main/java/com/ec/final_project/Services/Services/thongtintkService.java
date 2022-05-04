package com.ec.final_project.Services.Services;

import com.ec.final_project.Beans.thongtintk;

import java.util.List;

public interface thongtintkService {
    boolean CheckExist(thongtintk tk);
    void Create(thongtintk tk);
    List<thongtintk> getAll();
}
