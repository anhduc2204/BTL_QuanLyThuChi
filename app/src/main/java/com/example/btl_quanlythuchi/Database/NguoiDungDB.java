package com.example.btl_quanlythuchi.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.btl_quanlythuchi.Model.NguoiDungModel;

@Database(entities = {NguoiDungModel.class}, version = 1)
public abstract class NguoiDungDB extends RoomDatabase {

    private static final String DATABASE_NAME = "nguoidung.db";
    private static NguoiDungDB instance;

    public static synchronized NguoiDungDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), NguoiDungDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract NguoiDungDAO nguoiDungDAO ();



}
