package com.example.btl_quanlythuchi.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.btl_quanlythuchi.Model.MucTieuModel;

import java.util.List;

@Dao
public interface MucTieuDAO {

    @Insert
    void insertMucTieu(MucTieuModel mucTieu);

    @Update
    void updateMucTieu(MucTieuModel mucTieu);


    @Delete
    void deleteMucTieu(MucTieuModel mucTieu);

    @Query("select * from muctieu where id = :id")
    List<MucTieuModel> getMucTieuById(int id);

    @Query("select * from muctieu where loai = :loai and thang = :thang and nam = :nam")
    List<MucTieuModel> getMucTieu(String loai, int thang, int nam);

}
