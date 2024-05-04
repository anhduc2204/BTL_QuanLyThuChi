package com.example.btl_quanlythuchi.Database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.btl_quanlythuchi.Model.MucTieuModel;

@Database(entities = {MucTieuModel.class}, version = 1)
public abstract class MucTieuDB extends RoomDatabase {

    private static final String DATABASE_NAME = "muctieu.db";
    private static MucTieuDB instance;

    public static synchronized MucTieuDB getInstance(Context context){
        if(instance == null){
            instance = Room.databaseBuilder(context.getApplicationContext(), MucTieuDB.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract MucTieuDAO mucTieuDAO ();



}
