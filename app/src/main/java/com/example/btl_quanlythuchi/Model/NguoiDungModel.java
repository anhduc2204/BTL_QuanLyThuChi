package com.example.btl_quanlythuchi.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "nguoidung")
public class NguoiDungModel {

    @PrimaryKey
    private int id;
    private String ten;

    @ColumnInfo(name = "sodu")
    private long soDu;

    public NguoiDungModel() {
    }

    public NguoiDungModel(int id, String ten, long soDu) {
        this.id = id;
        this.ten = ten;
        this.soDu = soDu;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public long getSoDu() {
        return soDu;
    }

    public void setSoDu(long soDu) {
        this.soDu = soDu;
    }
}
