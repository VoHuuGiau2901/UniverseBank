package com.ec.final_project.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "interest_rate")
public class interest_rate {
    @Id
    private String period;
    private double interest_rate;

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String kyhan) {
        this.period = kyhan;
    }

    public double getInterest_rate() {
        return interest_rate;
    }

    public void setInterest_rate(double laisuat) {
        this.interest_rate = laisuat;
    }

    public interest_rate(String kyhan, double laisuat) {
        this.period = kyhan;
        this.interest_rate = laisuat;
    }

    public interest_rate() {
    }
}
