package com.example.btl_quanlythuchi.Model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "chitieu")
public class ChiTieuModel12 {






        @PrimaryKey(autoGenerate = true)
        private int id;

        private int ngay;
        private int thang;
        private int nam;
        private String loai;

        @ColumnInfo(name = "hoatdong")
        private String hoatDong;

        @ColumnInfo(name = "ghichu")
        private String ghiChu;

        @ColumnInfo(name = "chiphi")
        private long chiPhi;

        public ChiTieuModel12(int ngay,int thang,int nam ,String loai, String hoatDong, String ghiChu, long chiPhi) {
            this.ngay = ngay;
            this.thang=thang;
            this.nam=nam;
            this.loai = loai;
            this.hoatDong = hoatDong;
            this.ghiChu = ghiChu;
            this.chiPhi = chiPhi;
        }

        public ChiTieuModel12() {
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public int getNgay() {
            return ngay;
        }

        public int getThang() {
            return thang;
        }

        public int getNam() {
            return nam;
        }

        public void setNam(int nam) {
            this.nam = nam;
        }

        public void setThang(int thang) {
            this.thang = thang;
        }

        public void setNgay(int ngay) {
            this.ngay = ngay;
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

        public long getChiPhi() {
            return chiPhi;
        }

        public void setChiPhi(long chiPhi) {
            this.chiPhi = chiPhi;
        }
    }


