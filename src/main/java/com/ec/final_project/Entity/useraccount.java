package com.ec.final_project.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "useraccount")
public class useraccount {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Acc_id;
    private String username;
    private String password;
    private String name;
    private int role;
    private String phone;
    private String email;
    private String identity_number;

    public useraccount() {
    }

    public useraccount(int acc_id, String username, String password, String ten, int role, String sdt, String email, String soCMND) {
        Acc_id = acc_id;
        this.username = username;
        this.password = password;
        this.name = ten;
        this.role = role;
        this.phone = sdt;
        this.email = email;
        this.identity_number = soCMND;
    }

    public useraccount(String username, String password, String ten, int role, String sdt, String email, String soCMND) {
        this.username = username;
        this.password = password;
        this.name = ten;
        this.role = role;
        this.phone = sdt;
        this.email = email;
        this.identity_number = soCMND;
    }

    public String getName() {
        return name;
    }

    public void setName(String ten) {
        this.name = ten;
    }

    public int getAcc_id() {
        return Acc_id;
    }

    public void setAcc_id(int acc_id) {
        Acc_id = acc_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String taikhoan) {
        this.username = taikhoan;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String matkhau) {
        this.password = matkhau;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String sdt) {
        this.phone = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdentity_number() {
        return identity_number;
    }

    public void setIdentity_number(String soCMND) {
        this.identity_number = soCMND;
    }
}
