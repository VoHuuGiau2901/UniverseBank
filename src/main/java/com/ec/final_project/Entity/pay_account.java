package com.ec.final_project.Entity;

import javax.persistence.*;

@Entity
@Table(name = "pay_account")
public class pay_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String account_number;
    private double balance;

    @OneToOne
    @JoinColumn(name = "acc_id")
    private account Acc;

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

    public String getAccount_number() {
        return account_number;
    }

    public void setAccount_number(String sotaikhoan) {
        this.account_number = sotaikhoan;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double sotien) {
        this.balance = sotien;
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

    public pay_account() {
    }
}
