package com.ec.final_project.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class thongtintk {
    @Id
    private int Acc_id;
    private String taikhoan;
    private String matkhau;
    private int role;
    private String sdt;
    private String email;
    private String soCMND;

    public thongtintk() {
    }

    public thongtintk(String taikhoan, String matkhau, int role, String sdt, String email, String soCMND) {
        this.taikhoan = taikhoan;
        this.matkhau = matkhau;
        this.role = role;
        this.sdt = sdt;
        this.email = email;
        this.soCMND = soCMND;
    }

    public int getAcc_id() {
        return Acc_id;
    }

    public void setAcc_id(int acc_id) {
        Acc_id = acc_id;
    }

    public String getTaikhoan() {
        return taikhoan;
    }

    public void setTaikhoan(String taikhoan) {
        this.taikhoan = taikhoan;
    }

    public String getMatkhau() {
        return matkhau;
    }

    public void setMatkhau(String matkhau) {
        this.matkhau = matkhau;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSoCMND() {
        return soCMND;
    }

    public void setSoCMND(String soCMND) {
        this.soCMND = soCMND;
    }
}
