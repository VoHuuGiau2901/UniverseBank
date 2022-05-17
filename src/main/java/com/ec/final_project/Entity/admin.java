package com.ec.final_project.Entity;

import javax.persistence.*;

@Entity
@Table(name = "admin")
public class admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int adminId;

    private String adminAccount, adminPassword;

    private String role;

    public int getadminId() {
        return adminId;
    }

    public void setadminId(int id) {
        this.adminId = id;
    }

    public String getAdminAccount() {
        return adminAccount;
    }

    public void setAdminAccount(String adminAccount) {
        this.adminAccount = adminAccount;
    }

    public String getAdminPassword() {
        return adminPassword;
    }

    public void setAdminPassword(String adminPassword) {
        this.adminPassword = adminPassword;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
