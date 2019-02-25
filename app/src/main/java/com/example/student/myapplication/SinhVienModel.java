package com.example.student.myapplication;

import java.util.ArrayList;

public class SinhVienModel {
    public static String[] ma = new String[]{"sdsbs", "sdbs"};
    public static String[] ten = new String[]{"Nam", "Indonesia"};
    public static String[] mon = new String[]{"Việt Nam", "Indonesia"};
    public static int[] img = new int[]{R.drawable.ic_flag_laos, R.drawable.ic_flag_thailand};
    private static ArrayList<SinhVien> ls = null;

    public static ArrayList<SinhVien> getListSinhvienDemo() {
        if (ls == null) {
            SinhVienModel svModel = new SinhVienModel();
            svModel.initSinhvienList();
        }
        return ls;
    }

    private void initSinhvienList() {
        ls = new ArrayList<SinhVien>();
        for (int i = 0; i < ma.length; i++) {
            SinhVien sv = new SinhVien(ma[i],ten[i],mon[i], img[i]);
            ls.add(sv);
        }
    }

    public static boolean addSinhVien(SinhVien sv) {
        if (sv != null) {
            ls.add(sv);
            return true;
        }
        return false;
    }

    public static boolean removeSinhVien(int i) {
        ls.remove(i);
        return true;
    }

    public static ArrayList<SinhVien> updateSinhVien(int i, int img, String ten, String mon) {
        SinhVien sv = ls.get(i);
        sv.setTen(ten);
        sv.setMon(mon);
        sv.setImg_id(img);
        return ls;
    }

    public static ArrayList<SinhVien> getList() {
        return ls;
    }
}
