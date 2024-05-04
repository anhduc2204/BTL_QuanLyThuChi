package com.example.btl_quanlythuchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.btl_quanlythuchi.Constraint.Constraint;
import com.example.btl_quanlythuchi.Model.ChiTieuModel12;
import com.example.btl_quanlythuchi.Service.ChiTieuService;

public class KhoanThuChi extends AppCompatActivity {
    Spinner spngay, spthang1, spnam1, spthuchi1, sphd1;
    Button  btnLuuChiTieu, btnSuaChiTieu, btnXoaChiTieu;
    EditText  edtDuKien1, edtGhiChu1;
    ChiTieuModel12 chitieu;
    ChiTieuService ctService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_khoan_thu_chi);
        Toolbar toolbar = findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        anhxaViewct();
        initSpinnersct();
        ctService = new ChiTieuService();
// nhan intent
        Intent intent = this.getIntent();
        String action = intent.getStringExtra("action");

        if(action.equals(Constraint.ACTION_THEM_MOI)){
            btnLuuChiTieu.setVisibility(View.VISIBLE);
        }else if(action.equals(Constraint.ACTION_XOA_SUA)){
            btnSuaChiTieu.setVisibility(View.VISIBLE);
            btnXoaChiTieu.setVisibility(View.VISIBLE);

        }

        View.OnClickListener onClickButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btnLuuChiTieu){
                    if(!kiemTraDuLieu()){
                        Toast.makeText(KhoanThuChi.this, "Chưa nhập chi phí dự kiến", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    chitieu = anhxaModel();
                    ctService.insertChiTieu(KhoanThuChi.this, chitieu);
                    Toast.makeText(KhoanThuChi.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                }else if(view.getId() == R.id.btnSuaMucTieu){
                    //
                }else if(view.getId() == R.id.btnXoaMucTieu){

                }


            }
        };


        btnLuuChiTieu.setOnClickListener(onClickButton);
        btnSuaChiTieu.setOnClickListener(onClickButton);
        btnXoaChiTieu.setOnClickListener(onClickButton);

    }








    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
    public boolean kiemTraDuLieu(){
        String dukien = edtDuKien1.getText().toString().trim();
        if(TextUtils.isEmpty(dukien)){
            return false;

        }
        return true;
    }

    public void anhxaViewct(){
     spngay=(Spinner)findViewById(R.id.spngay1)   ;
    spthuchi1 = (Spinner) findViewById(R.id.spthuchi12);
    spthang1 = (Spinner) findViewById(R.id.spthang12);
    spnam1 = (Spinner) findViewById(R.id.spnam12);
    sphd1 = (Spinner) findViewById(R.id.sphd12);

    edtDuKien1 = findViewById(R.id.edtDuKien12);
    edtGhiChu1 = findViewById(R.id.edtGhiChuMucTieu12);

    btnLuuChiTieu = findViewById(R.id.btnLuuChiTieu);
    btnXoaChiTieu = findViewById(R.id.btnXoaChiTieu);
    btnSuaChiTieu = findViewById(R.id.btnSuaChiTieu);
}
    public ChiTieuModel12 anhxaModel(){
        ChiTieuModel12 mt = null;
        int ngay= Integer.parseInt(spngay.getSelectedItem().toString());
        int thang = Integer.parseInt( spthang1.getSelectedItem().toString());
        int nam = Integer.parseInt( spnam1.getSelectedItem().toString());
        String loai = spthuchi1.getSelectedItem().toString();
        String hoatdong = sphd1.getSelectedItem().toString();
        long dukien = Long.parseLong(edtDuKien1.getText().toString().trim());
        String ghichu = edtGhiChu1.getText().toString().trim();

        mt = new ChiTieuModel12(ngay, thang, nam,loai, hoatdong,  ghichu,dukien);

        return mt;
    }

    public void initSpinnersct(){
        //Spiner ngay
        ArrayAdapter<String> aa0 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Constraint.ARRAY_NGAY);
        spngay.setAdapter(aa0);

        //Spinner tháng
        ArrayAdapter<String> aa1 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Constraint.ARRAY_THANG);
        spthang1.setAdapter(aa1);

        //Spinner Năm
        ArrayAdapter aa2 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Constraint.ARRAY_NAM);
        spnam1.setAdapter(aa2);

        //spinner hoạt động
        ArrayAdapter<String> aa3 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, Constraint.ARRAY_HOAT_DONG);
        sphd1.setAdapter(aa3);

        // Spinner loại thu chi
        ArrayAdapter<String> aa4 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, Constraint.ARRAY_LOAI);
        spthuchi1.setAdapter(aa4);

        //Sự kiện click item
        AdapterView.OnItemSelectedListener onClickItem = new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        };


    }
}
