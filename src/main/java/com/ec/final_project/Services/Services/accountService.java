package com.ec.final_project.Services.Services;

import com.ec.final_project.Entity.useraccount;

import java.util.List;

public interface accountService {
    boolean CheckExist(useraccount tk);

    void Create(useraccount tk);

    List<useraccount> getAll();

    void delete_Acc(int id);

    useraccount validate(String username, String password);

    useraccount FindByEmail(String email);

    Object findByIdentityNumber(String identityNumber);

    void UpdatePassword(int acc_id, String newPassword);

    useraccount findByUsername(String username);
}
