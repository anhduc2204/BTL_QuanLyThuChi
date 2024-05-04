package com.example.btl_quanlythuchi.Database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.btl_quanlythuchi.Model.NguoiDungModel;

import java.util.List;

@Dao
public interface NguoiDungDAO {

    @Insert
    void insertNguoiDung(NguoiDungModel nguoiDung);

    @Update
    void updateNguoiDung(NguoiDungModel nguoiDung);

    @Query("SELECT * FROM nguoidung")
    List<NguoiDungModel> getListNguoiDung();

    @Query("select * from nguoidung where id = :id")
    List<NguoiDungModel> getNguoiDungById(int id);

}
