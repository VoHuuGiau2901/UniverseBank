package com.ec.final_project.Beans;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.sql.Date;


@Entity
public class taikhoan_tietkiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private int acc_id;

    private double sotien;
    private Date ngaygui;
    private Date ngaydaohan;
    private String tuychon;
    private String sotaikhoan;

    @ManyToOne
    @JoinColumn(name = "acc_id")
    private thongtintk Acc;

    @OneToOne
    @JoinColumn(name = "kyhan")
    private laisuat ls;

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
        return this.Acc.getAcc_id();
    }

    public void setAcc_id(int acc_id) {
        Acc = new thongtintk();
        this.Acc.setAcc_id(acc_id);
    }

    public String getKyhan() {
        return this.ls.getKyhan();
    }

    public void setKyhan(String kyhan) {
        ls = new laisuat();
        this.ls.setKyhan(kyhan);
    }

//    public taikhoan_tietkiem(int id, double sotien, Date ngaygui, Date ngaydaohan, String tuychon, String sotaikhoan, int acc_id, String kyhan) {
//        this.id = id;
//        this.sotien = sotien;
//        this.ngaygui = ngaygui;
//        this.ngaydaohan = ngaydaohan;
//        this.tuychon = tuychon;
//        this.sotaikhoan = sotaikhoan;
//        this.acc_id = acc_id;
//        this.kyhan = kyhan;
//    }
//
//    public taikhoan_tietkiem(double sotien, Date ngaygui, Date ngaydaohan, String tuychon, String sotaikhoan, int acc_id, String kyhan) {
//        this.sotien = sotien;
//        this.ngaygui = ngaygui;
//        this.ngaydaohan = ngaydaohan;
//        this.tuychon = tuychon;
//        this.sotaikhoan = sotaikhoan;
//        this.acc_id = acc_id;
//        this.kyhan = kyhan;
//    }

    public taikhoan_tietkiem() {
    }
}
