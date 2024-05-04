package com.example.btl_quanlythuchi.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity (tableName = "muctieu")
public class MucTieuModel {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int thang;
    private int nam;
    private String loai;

    @ColumnInfo(name = "hoatdong")
    private String hoatDong;

    @ColumnInfo(name = "ghichu")
    private String ghiChu;

    @ColumnInfo(name = "chiphidukien")
    private long chiPhiDuKien;

    public MucTieuModel(String loai, int thang, int nam, String hoatDong, long chiPhiDuKien, String ghiChu) {
        this.thang = thang;
        this.nam = nam;
        this.loai = loai;
        this.hoatDong = hoatDong;
        this.ghiChu = ghiChu;
        this.chiPhiDuKien = chiPhiDuKien;
    }

    public MucTieuModel() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getThang() {
        return thang;
    }

    public void setThang(int thang) {
        this.thang = thang;
    }

    public int getNam() {
        return nam;
    }

    public void setNam(int nam) {
        this.nam = nam;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public String getHoatDong() {
        return hoatDong;
    }

    public void setHoatDong(String hoatDong) {
        this.hoatDong = hoatDong;
    }

    public String getGhiChu() {
        return ghiChu;
    }

    public void setGhiChu(String ghiChu) {
        this.ghiChu = ghiChu;
    }

    public long getChiPhiDuKien() {
        return chiPhiDuKien;
    }

    public void setChiPhiDuKien(long chiPhiDuKien) {
        this.chiPhiDuKien = chiPhiDuKien;
    }
}
