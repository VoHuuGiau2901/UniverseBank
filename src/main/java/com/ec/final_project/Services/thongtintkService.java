package com.ec.final_project.Services;

import com.ec.final_project.Beans.thongtintk;

import java.util.List;

public interface thongtintkService {
    thongtintk kiemtratk(thongtintk tk);

    void savethongtintk(thongtintk tk);

//    thongtintk timthongtin(thongtintk tk);

    List<thongtintk> getAlltk();

//    Optional<thongtintk> findbyID(int id);

//    int getMaxID();
}
