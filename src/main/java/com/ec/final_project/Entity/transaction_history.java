package com.ec.final_project.Entity;

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
    private int acc_id;

    @ManyToOne
    private account Acc;

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
        return acc_id;
    }

    public void setAcc_id(int acc_id) {
        this.acc_id = acc_id;
    }

    public transaction_history(int lichsu_id, Date ngay, double sotiengiaodich, int hinhthuc, int acc_id) {
        this.id = lichsu_id;
        this.date = ngay;
        this.amount = sotiengiaodich;
        this.transaction_type = hinhthuc;
        this.acc_id = acc_id;
    }

    public transaction_history(Date ngay, double sotiengiaodich, int hinhthuc, int acc_id) {
        this.date = ngay;
        this.amount = sotiengiaodich;
        this.transaction_type = hinhthuc;
        this.acc_id = acc_id;
    }

    public transaction_history() {
    }
}
