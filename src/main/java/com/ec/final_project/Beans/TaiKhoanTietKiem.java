package com.ec.final_project.Beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Date;

@Entity
public class TaiKhoanTietKiem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private BigDecimal SoTien;
    private Date NgayGui;
    private Date NgayDaoHan;
    private int TuyChon;
    private String SoTaiKhoan;
    private int Acc_id;
    private int KyHan;

    public TaiKhoanTietKiem() {
    }

    public TaiKhoanTietKiem(int id, BigDecimal soTien, Date ngayGui, Date ngayDaoHan, int tuyChon, String soTaiKhoan, int acc_id, int kyHan) {
        this.id = id;
        SoTien = soTien;
        NgayGui = ngayGui;
        NgayDaoHan = ngayDaoHan;
        TuyChon = tuyChon;
        SoTaiKhoan = soTaiKhoan;
        Acc_id = acc_id;
        KyHan = kyHan;
    }

    public TaiKhoanTietKiem(BigDecimal soTien, Date ngayGui, Date ngayDaoHan, int tuyChon, String soTaiKhoan, int acc_id, int kyHan) {
        SoTien = soTien;
        NgayGui = ngayGui;
        NgayDaoHan = ngayDaoHan;
        TuyChon = tuyChon;
        SoTaiKhoan = soTaiKhoan;
        Acc_id = acc_id;
        KyHan = kyHan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public BigDecimal getSoTien() {
        return SoTien;
    }

    public void setSoTien(BigDecimal soTien) {
        SoTien = soTien;
    }

    public Date getNgayGui() {
        return NgayGui;
    }

    public void setNgayGui(Date ngayGui) {
        NgayGui = ngayGui;
    }

    public Date getNgayDaoHan() {
        return NgayDaoHan;
    }

    public void setNgayDaoHan(Date ngayDaoHan) {
        NgayDaoHan = ngayDaoHan;
    }

    public int getTuyChon() {
        return TuyChon;
    }

    public void setTuyChon(int tuyChon) {
        TuyChon = tuyChon;
    }

    public String getSoTaiKhoan() {
        return SoTaiKhoan;
    }

    public void setSoTaiKhoan(String soTaiKhoan) {
        SoTaiKhoan = soTaiKhoan;
    }

    public int getAcc_id() {
        return Acc_id;
    }

    public void setAcc_id(int acc_id) {
        Acc_id = acc_id;
    }

    public int getKyHan() {
        return KyHan;
    }

    public void setKyHan(int kyHan) {
        KyHan = kyHan;
    }
}
