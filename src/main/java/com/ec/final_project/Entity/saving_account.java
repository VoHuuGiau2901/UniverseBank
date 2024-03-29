package com.ec.final_project.Entity;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;


@Entity
@Table(name = "saving_account")
public class saving_account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
//    private int acc_id;

    private double deposit;
    private Date start_date;
    private Date end_date;
    private String saving_option;

    @ManyToOne
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "acc_id")
    private useraccount Acc;

    @OneToOne
    @JoinColumn(name = "period")
    private interest_rate ls;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getDeposit() {
        return deposit;
    }

    public void setDeposit(double sotien) {
        this.deposit = sotien;
    }

    public Date getStart_date() {
        return start_date;
    }

    public void setStart_date(Date start_date) {
        this.start_date = start_date;
    }

    public Date getEnd_date() {
        return end_date;
    }

    public void setEnd_date(Date end_date) {
        this.end_date = end_date;
    }

    public String getSaving_option() {
        return saving_option;
    }

    public void setSaving_option(String tuychon) {
        this.saving_option = tuychon;
    }


    public int getAcc_id() {
        return this.Acc.getAcc_id();
    }

    public void setAcc_id(int acc_id) {
        Acc = new useraccount();
        this.Acc.setAcc_id(acc_id);
    }

    public String getPeriod() {
        return this.ls.getPeriod();
    }

    public void setPeriod(String kyhan) {
        ls = new interest_rate();
        this.ls.setPeriod(kyhan);
    }

    public saving_account() {
    }
}
