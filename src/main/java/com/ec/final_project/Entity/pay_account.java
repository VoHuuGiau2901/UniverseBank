package com.ec.final_project.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "acc_id")
    private useraccount Acc;

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

    public pay_account() {
    }
}
