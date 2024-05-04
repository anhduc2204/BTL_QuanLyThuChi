package com.example.btl_quanlythuchi.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.btl_quanlythuchi.Model.ChiTieuModel12;

@Database(entities = {ChiTieuModel12.class}, version = 3)
public abstract class ChiTieuDB extends RoomDatabase {

    private static final String DATABASE_NAME = "chitieu.db";
    private static ChiTieuDB instance;

    public static synchronized ChiTieuDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), ChiTieuDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract ChiTieuDAO chiTieuDAO ();



}
