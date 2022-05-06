package com.ec.final_project.Services.Services;

import com.ec.final_project.Entity.transaction_history;

import java.util.List;

public interface transaction_hisotryService {
    List<transaction_history> getAll();
    void Create(transaction_history lsGD);
}
