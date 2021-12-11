package com.ec.final_project.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class lichsugiaodich {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int lichsu_id;
    private Date ngay;
    private double sotiengiaodich;
    private int hinhthuc;
    private int acc_id;

    public int getLichsu_id() {
        return lichsu_id;
    }

    public void setLichsu_id(int lichsu_id) {
        this.lichsu_id = lichsu_id;
    }

    public Date getNgay() {
        return ngay;
    }

    public void setNgay(Date ngay) {
        this.ngay = ngay;
    }

    public double getSotiengiaodich() {
        return sotiengiaodich;
    }

    public void setSotiengiaodich(double sotiengiaodich) {
        this.sotiengiaodich = sotiengiaodich;
    }

    public int getHinhthuc() {
        return hinhthuc;
    }

    public void setHinhthuc(int hinhthuc) {
        this.hinhthuc = hinhthuc;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public lichsugiaodich(int lichsu_id, Date ngay, double sotiengiaodich, int hinhthuc, int acc_id) {
        this.lichsu_id = lichsu_id;
        this.ngay = ngay;
        this.sotiengiaodich = sotiengiaodich;
        this.hinhthuc = hinhthuc;
        this.acc_id = acc_id;
    }

    public lichsugiaodich(Date ngay, double sotiengiaodich, int hinhthuc, int acc_id) {
        this.ngay = ngay;
        this.sotiengiaodich = sotiengiaodich;
        this.hinhthuc = hinhthuc;
        this.acc_id = acc_id;
    }

    public lichsugiaodich() {
    }
}
