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
import com.example.btl_quanlythuchi.Model.MucTieuModel;

import com.example.btl_quanlythuchi.Constraint.Constraint;
import com.example.btl_quanlythuchi.Service.MucTieuService;

public class MucTieu extends AppCompatActivity {
    Spinner spthang, spnam, spthuchi, sphd;
    Button btnLuu, btnSua, btnXoa;
    EditText edtDuKien, edtGhiChu;
    MucTieuModel mucTieu;
    MucTieuService mtService = new MucTieuService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_muc_tieu);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        anhxaView();
        initSpinners();

        Intent intent = this.getIntent();
        String action = intent.getStringExtra("action");

        if(action.equals(Constraint.ACTION_THEM_MOI)){
            btnLuu.setVisibility(View.VISIBLE);
        }else if(action.equals(Constraint.ACTION_XOA_SUA)){
            btnLuu.setVisibility(View.VISIBLE);
            btnXoa.setVisibility(View.VISIBLE);

        }


        // sự kiện click button
        View.OnClickListener onClickButton = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(view.getId() == R.id.btnLuuMucTieu){
                    if(!kiemTraDuLieu()){
                        Toast.makeText(MucTieu.this, "Chưa nhập chi phí dự kiến", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    mucTieu = anhxaModel();
                    mtService.insertMucTieu(MucTieu.this, mucTieu);
                    Toast.makeText(MucTieu.this, "Lưu thành công", Toast.LENGTH_SHORT).show();
                }else if(view.getId() == R.id.btnSuaMucTieu){
                    //
                }else if(view.getId() == R.id.btnXoaMucTieu){

                }


            }
        };

        btnLuu.setOnClickListener(onClickButton);
        btnSua.setOnClickListener(onClickButton);
        btnXoa.setOnClickListener(onClickButton);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }

    public void anhxaView(){
        spthuchi = (Spinner) findViewById(R.id.spthuchi1);
        spthang = (Spinner) findViewById(R.id.spthang22);
        spnam = (Spinner) findViewById(R.id.spnam22);
        sphd = (Spinner) findViewById(R.id.sphd1);

        edtDuKien = findViewById(R.id.edtDuKien1);
        edtGhiChu = findViewById(R.id.edtGhiChuMucTieu12);

        btnLuu = findViewById(R.id.btnLuuMucTieu);
        btnXoa = findViewById(R.id.btnXoaMucTieu);
        btnSua = findViewById(R.id.btnSuaMucTieu);
    }

    public MucTieuModel anhxaModel(){
        MucTieuModel mt = null;

        int thang = Integer.parseInt( spthang.getSelectedItem().toString());
        int nam = Integer.parseInt( spnam.getSelectedItem().toString());
        String loai = spthuchi.getSelectedItem().toString();
        String hoatdong = sphd.getSelectedItem().toString();
        long dukien = Long.parseLong(edtDuKien.getText().toString().trim());
        String ghichu = edtGhiChu.getText().toString().trim();

        mt = new MucTieuModel(loai, thang, nam, hoatdong, dukien, ghichu);

        return mt;
    }

    public boolean kiemTraDuLieu(){
        String dukien = edtDuKien.getText().toString().trim();
        if(TextUtils.isEmpty(dukien)){
            return false;

        }
        return true;
    }

    public void initSpinners(){
        //Spinner tháng
        ArrayAdapter<String> aa1 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Constraint.ARRAY_THANG);
        spthang.setAdapter(aa1);

        //Spinner Năm
        ArrayAdapter aa2 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Constraint.ARRAY_NAM);
        spnam.setAdapter(aa2);

        //spinner hoạt động
        ArrayAdapter<String> aa3 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, Constraint.ARRAY_HOAT_DONG);
        sphd.setAdapter(aa3);

        // Spinner loại thu chi
        ArrayAdapter<String> aa4 = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item, Constraint.ARRAY_LOAI);
        spthuchi.setAdapter(aa4);

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