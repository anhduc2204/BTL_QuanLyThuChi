package com.example.btl_quanlythuchi.Service;

import android.content.Context;

import com.example.btl_quanlythuchi.Database.ChiTieuDB;

import com.example.btl_quanlythuchi.Database.MucTieuDB;
import com.example.btl_quanlythuchi.Model.ChiTieuModel12;
import com.example.btl_quanlythuchi.Model.MucTieuModel;
import com.example.btl_quanlythuchi.MucTieuAdapter;

import java.util.List;

public class ChiTieuService {

    public void insertChiTieu(Context context, ChiTieuModel12 chiTieu){
        ChiTieuDB.getInstance(context).chiTieuDAO().insertChiTieu(chiTieu);
    }

    public List<ChiTieuModel12> getChiTieuByThangNam(Context context, int thang, int nam){
        return ChiTieuDB.getInstance(context).chiTieuDAO().getChiTieuByThangNam(thang, nam);
    }

    public void updateChiTieu(Context context, ChiTieuModel12 chiTieu){
        ChiTieuDB.getInstance(context).chiTieuDAO().updateChiTieu(chiTieu);
    }

    public void deleteChiTieu(Context context, ChiTieuModel12 chiTieu){
        ChiTieuDB.getInstance(context).chiTieuDAO().deleteChiTieu(chiTieu);
    }

    public List<ChiTieuModel12>  getChiTieuById(Context context, int id){
        return ChiTieuDB.getInstance(context).chiTieuDAO().getChiTieuById(id);
    }
    public List<ChiTieuModel12> getChiTieu(Context context, String loai, int thang, int nam){
        return ChiTieuDB.getInstance(context).chiTieuDAO().getChiTieu(loai, thang, nam);
    }
    public long getTongChiTieu(Context context, String loai, String hoatDong, int thang, int nam){
        return ChiTieuDB.getInstance(context).chiTieuDAO().getTongChiTieu(loai, hoatDong, thang, nam);
    }

    public long getTongKhoanThu(Context context, int thang, int nam){

        //Xử lý
        return 0;
    }

    public long getTongKhoanChi(Context context, int thang, int nam){
        //Xử lý
        return 0;
    }

}
