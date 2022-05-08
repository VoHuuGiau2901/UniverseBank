package com.ec.final_project.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;


@Entity
@Table(name = "transaction_history")
public class transaction_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private Date date;
    private double amount;
    private int transaction_type;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "acc_id")
    private useraccount Acc = new useraccount();;

    public int getId() {
        return id;
    }

    public void setId(int lichsu_id) {
        this.id = lichsu_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date ngay) {
        this.date = ngay;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double sotiengiaodich) {
        this.amount = sotiengiaodich;
    }

    public int getTransaction_type() {
        return transaction_type;
    }

    public void setTransaction_type(int hinhthuc) {
        this.transaction_type = hinhthuc;
    }

    public int getAcc_id() {
        return Acc.getAcc_id();
    }

    public void setAcc_id(int acc_id) {
        this.Acc.setAcc_id(acc_id);
    }

    public transaction_history(Date ngay, double sotiengiaodich, int hinhthuc, int acc_id) {
        this.date = ngay;
        this.amount = sotiengiaodich;
        this.transaction_type = hinhthuc;
        this.Acc.setAcc_id(acc_id);
    }

    public transaction_history() {
    }
}
