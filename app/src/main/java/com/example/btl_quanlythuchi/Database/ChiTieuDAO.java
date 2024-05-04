package com.example.btl_quanlythuchi.Database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.btl_quanlythuchi.Model.ChiTieuModel12;

import java.util.List;

@Dao
public interface ChiTieuDAO {

    @Insert
    void insertChiTieu(ChiTieuModel12 chiTieu);

    @Update
    void updateChiTieu(ChiTieuModel12 chiTieu);

    @Delete
    void deleteChiTieu(ChiTieuModel12 chiTieu);

    @Query("SELECT * FROM chitieu")
    List<ChiTieuModel12> getListChiTieu();

    @Query("select * from chitieu where id = :id")
    List<ChiTieuModel12> getChiTieuById(int id);

    @Query("select * from chitieu where strftime('%m', ngay) = :thang and strftime('%Y',ngay) = :nam")
    List<ChiTieuModel12> getChiTieuByThangNam(int thang, int nam);

    @Query("select sum(chiphi) from chitieu where " +
            "loai = :loai and hoatdong = :hoatDong and "+
            "strftime('%m', ngay) = :thang and strftime('%Y',ngay) = :nam")
    long getTongChiTieu(String loai, String hoatDong, int thang, int nam);
    @Query("select * from chitieu where loai = :loai and thang = :thang and nam = :nam")
    List<ChiTieuModel12> getChiTieu(String loai, int thang, int nam);
}
