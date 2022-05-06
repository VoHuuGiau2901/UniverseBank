package com.ec.final_project.Services.Services;

import com.ec.final_project.Entity.interest_rate;

import java.util.List;

public interface interest_rateService {
    List<interest_rate> getAll();

    void Update(double l, String k);

    void Insert_First(double l, String k);
}
