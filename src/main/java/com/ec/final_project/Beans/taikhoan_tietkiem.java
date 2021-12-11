package com.ec.final_project.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class taikhoan_tietkiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private double sotien;
    private Date ngaygui;
    private Date ngaydaohan;
    private String tuychon;
    private String sotaikhoan;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

    public Date getNgaygui() {
        return ngaygui;
    }

    public void setNgaygui(Date ngaygui) {
        this.ngaygui = ngaygui;
    }

    public Date getNgaydaohan() {
        return ngaydaohan;
    }

    public void setNgaydaohan(Date ngaydaohan) {
        this.ngaydaohan = ngaydaohan;
    }

    public String getTuychon() {
        return tuychon;
    }

    public void setTuychon(String tuychon) {
        this.tuychon = tuychon;
    }

    public String getSotaikhoan() {
        return sotaikhoan;
    }

    public void setSotaikhoan(String sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public int getAcc_id() {
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public String getKyhan() {
        return kyhan;
    }

    public void setKyhan(String kyhan) {
        this.kyhan = kyhan;
    }

    public taikhoan_tietkiem(int id, double sotien, Date ngaygui, Date ngaydaohan, String tuychon, String sotaikhoan, int acc_id, String kyhan) {
        this.id = id;
        this.sotien = sotien;
        this.ngaygui = ngaygui;
        this.ngaydaohan = ngaydaohan;
        this.tuychon = tuychon;
        this.sotaikhoan = sotaikhoan;
        this.acc_id = acc_id;
        this.kyhan = kyhan;
    }

    public taikhoan_tietkiem(double sotien, Date ngaygui, Date ngaydaohan, String tuychon, String sotaikhoan, int acc_id, String kyhan) {
        this.sotien = sotien;
        this.ngaygui = ngaygui;
        this.ngaydaohan = ngaydaohan;
        this.tuychon = tuychon;
        this.sotaikhoan = sotaikhoan;
        this.acc_id = acc_id;
        this.kyhan = kyhan;
    }

    public taikhoan_tietkiem() {
    }

    private int acc_id;
    private String kyhan;

}
