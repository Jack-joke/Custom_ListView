package com.example.student.myapplication;

import java.util.Objects;

public class SinhVien {
    private String ma;
    private String ten;
    private String mon;
    private int img_id;

    public String getMa() {
        return ma;
    }

    public void setMa(String ma) {
        this.ma = ma;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getMon() {
        return mon;
    }

    public void setMon(String mon) {
        this.mon = mon;
    }

    public int getImg_id() {
        return img_id;
    }

    public void setImg_id(int img_id) {
        this.img_id = img_id;
    }

    public SinhVien() {
    }

    public SinhVien(String ma, String ten, String mon, int img_id) {
        this.ma = ma;
        this.ten = ten;
        this.mon = mon;
        this.img_id = img_id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SinhVien sinhVien = (SinhVien) o;
        return Objects.equals(ma, sinhVien.ma);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ma);
    }
}
