package com.ec.final_project.Beans;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class laisuat {
    @Id
    private String kyhan;
    private double laisuat;

    public String getKyhan() {
        return kyhan;
    }

    public void setKyhan(String kyhan) {
        this.kyhan = kyhan;
    }

    public double getLaisuat() {
        return laisuat;
    }

    public void setLaisuat(double laisuat) {
        this.laisuat = laisuat;
    }

    public laisuat(String kyhan, double laisuat) {
        this.kyhan = kyhan;
        this.laisuat = laisuat;
    }

    public laisuat() {
    }
}
