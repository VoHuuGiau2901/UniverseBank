package com.ec.final_project.Services;

import com.ec.final_project.Beans.lichsugiaodich;

import java.util.List;

public interface lichsugiaodichService {
    List<lichsugiaodich> getAll();
    void addNew_GiaoDich(lichsugiaodich lsGD);
    Object get_total_user_and_money();
    List<Object> get_money_percent_stonk_per_period();
}
