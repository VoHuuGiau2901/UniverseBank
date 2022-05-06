package com.ec.final_project.Entity;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "interest_rate_history")
public class interest_rate_history {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int interest_rate_old;

    private Date expire_day;

    private int period;

    @ManyToOne
    private interest_rate Interest_Rate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInterest_rate_old() {
        return interest_rate_old;
    }

    public void setInterest_rate_old(int interest_rateOld) {
        this.interest_rate_old = interest_rateOld;
    }

    public Date getExpire_day() {
        return expire_day;
    }

    public void setExpire_day(Date expire_day) {
        this.expire_day = expire_day;
    }

    public int getPeriod() {
        return period;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public interest_rate getInterest_Rate() {
        return Interest_Rate;
    }

    public void setInterest_Rate(interest_rate ls) {
        this.Interest_Rate = ls;
    }


}
