package com.example.btl_quanlythuchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.btl_quanlythuchi.Database.NguoiDungDB;
import com.example.btl_quanlythuchi.Model.NguoiDungModel;

import java.util.List;

public class NguoiDung extends AppCompatActivity {

    EditText edt_ten, edt_sodu;
    NguoiDungModel nguoiDung;
    Button btn_luu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nguoi_dung);

        Toolbar toolbar = findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        edt_ten = findViewById(R.id.edt_ten);
        edt_sodu = findViewById(R.id.edt_sodu);
        btn_luu = findViewById(R.id.btn_luuNguoiDung);

        List<NguoiDungModel> list = NguoiDungDB.getInstance(this).nguoiDungDAO().getNguoiDungById(1);
        if(list != null && !list.isEmpty()){
            nguoiDung = list.get(0);
        }

        edt_ten.setText(nguoiDung.getTen());
        edt_sodu.setText(nguoiDung.getSoDu()+"");

        btn_luu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                luuNguoiDung();
            }
        });

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    private void luuNguoiDung() {
        nguoiDung.setTen(edt_ten.getText()+"");
        Long sodu = Long.parseLong(edt_sodu.getText() + "");
        nguoiDung.setSoDu(sodu);

        NguoiDungDB.getInstance(this).nguoiDungDAO().updateNguoiDung(nguoiDung);
        Toast.makeText(this, "Cập nhật thành công", Toast.LENGTH_SHORT).show();
    }


}