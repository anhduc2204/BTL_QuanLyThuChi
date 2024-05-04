package com.example.btl_quanlythuchi.Service;

import android.content.Context;

import com.example.btl_quanlythuchi.Database.MucTieuDB;
import com.example.btl_quanlythuchi.Model.MucTieuModel;

import java.util.List;

public class MucTieuService {

    public void insertMucTieu(Context context, MucTieuModel mucTieu){
        MucTieuDB.getInstance(context).mucTieuDAO().insertMucTieu(mucTieu);
    }

    public void updateMucTieu(Context context, MucTieuModel mucTieu){
        MucTieuDB.getInstance(context).mucTieuDAO().updateMucTieu(mucTieu);
    }

    public void deleteMucTieu(Context context, MucTieuModel mucTieu){
        MucTieuDB.getInstance(context).mucTieuDAO().deleteMucTieu(mucTieu);
    }

    public List<MucTieuModel>  getMucTieuById(Context context, int id){
        return MucTieuDB.getInstance(context).mucTieuDAO().getMucTieuById(id);
    }

    public List<MucTieuModel> getMucTieu(Context context, String loai, int thang, int nam){
        return MucTieuDB.getInstance(context).mucTieuDAO().getMucTieu(loai, thang, nam);
    }

}
