package com.ec.final_project.Services;

import com.ec.final_project.Beans.laisuat;

import java.util.List;

public interface laisuatService {
    List<laisuat> getAll();
    void change(float l,String k);
 }
