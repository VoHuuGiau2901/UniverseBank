package com.ec.final_project.Beans;

import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "taikhoan_thanhtoan")
public class taikhoan_thanhtoan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String sotaikhoan;
    private double sotien;

    @OneToOne
    @JoinColumn(name = "acc_id")
    private thongtintk Acc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAcc_id() {
        return Acc.getAcc_id();
    }

    public void setAcc_id(int Acc_id) {
        this.Acc.setAcc_id(Acc_id);
    }

    public String getSotaikhoan() {
        return sotaikhoan;
    }

    public void setSotaikhoan(String sotaikhoan) {
        this.sotaikhoan = sotaikhoan;
    }

    public double getSotien() {
        return sotien;
    }

    public void setSotien(double sotien) {
        this.sotien = sotien;
    }

//    public taikhoan_thanhtoan(int id, int acc_id, String sotaikhoan, double sotien) {
//        this.id = id;
//        this.acc_id = acc_id;
//        this.sotaikhoan = sotaikhoan;
//        this.sotien = sotien;
//    }
//
//    public taikhoan_thanhtoan(int acc_id, String sotaikhoan, double sotien) {
//        this.acc_id = acc_id;
//        this.sotaikhoan = sotaikhoan;
//        this.sotien = sotien;
//    }

    public taikhoan_thanhtoan() {
    }
}
