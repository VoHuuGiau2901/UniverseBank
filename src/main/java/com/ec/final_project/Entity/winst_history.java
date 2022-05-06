package com.ec.final_project.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "winst_history")
public class winst_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int interest_rate;

    private int winst;

    private Date date;

    private int saving_account_id;

    @ManyToOne
    private saving_account saving_Acc;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(int interest_rate) {
        this.interest_rate = interest_rate;
    }

    public int getWinst() {
        return winst;
    }

    public void setWinst(int winst) {
        this.winst = winst;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getSaving_account_id() {
        return saving_account_id;
    }

    public void setSaving_account_id(int saving_account_id) {
        this.saving_account_id = saving_account_id;
    }

    public saving_account getSaving_Acc() {
        return saving_Acc;
    }

    public void setSaving_Acc(saving_account saving_Acc) {
        this.saving_Acc = saving_Acc;
    }
}
