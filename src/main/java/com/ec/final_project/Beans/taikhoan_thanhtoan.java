package com.ec.final_project.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class taikhoan_thanhtoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int acc_id;
    private int sotaikhoan;
    private double sotien;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public int getSotaikhoan() {
        return sotaikhoan;
    }

    public void setSotaikhoan(int sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

    public taikhoan_thanhtoan(int id, int acc_id, int sotaikhoan, double sotien) {
        this.id = id;
        this.acc_id = acc_id;
        this.sotaikhoan = sotaikhoan;
        this.sotien = sotien;
    }

    public taikhoan_thanhtoan(int acc_id, int sotaikhoan, double sotien) {
        this.acc_id = acc_id;
        this.sotaikhoan = sotaikhoan;
        this.sotien = sotien;
    }

    public taikhoan_thanhtoan() {
    }
}
