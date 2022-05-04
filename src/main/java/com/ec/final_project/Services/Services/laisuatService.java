package com.ec.final_project.Services.Services;

import com.ec.final_project.Beans.laisuat;

import java.util.List;

public interface laisuatService {
    List<laisuat> getAll();

    void Update(double l, String k);

    void Insert_First(double l, String k);
}
