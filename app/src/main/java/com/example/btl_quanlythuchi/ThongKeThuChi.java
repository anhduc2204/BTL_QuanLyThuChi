package com.example.btl_quanlythuchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.btl_quanlythuchi.Constraint.Constraint;
import com.example.btl_quanlythuchi.Model.ChiTieuModel12;

import com.example.btl_quanlythuchi.Service.ChiTieuService;


import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThongKeThuChi extends AppCompatActivity {
    TextView chira,thuvao,ngansachthang;
    Spinner spthang, spnam;
    Button btnXem;
    RecyclerView rcvChiTieu_khoanthu, rcvChiTieu_khoanchi;

    ChiTieuAdapter chiTieuAdapter_thu;
    ChiTieuAdapter chiTieuAdapter_chi;
    List<ChiTieuModel12> mListChiTieu_khoanthu;
    List<ChiTieuModel12> mListChiTieu_khoanchi;

    ChiTieuService ctService = new ChiTieuService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_thu_chi);
        Toolbar toolbar = findViewById(R.id.toolbar5);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        anhxaView();
        initSpinners();

        // mục tiêu khoản thu
        chiTieuAdapter_thu = new ChiTieuAdapter( this);
        mListChiTieu_khoanthu = new ArrayList<>();
        chiTieuAdapter_thu.setData(mListChiTieu_khoanthu);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        rcvChiTieu_khoanthu.setLayoutManager(linearLayoutManager1);
        rcvChiTieu_khoanthu.setAdapter(chiTieuAdapter_thu);

        //mục tiêu khoản chi
        chiTieuAdapter_chi = new ChiTieuAdapter(this);
        mListChiTieu_khoanchi = new ArrayList<>();
        chiTieuAdapter_chi.setData(mListChiTieu_khoanchi);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        rcvChiTieu_khoanchi.setLayoutManager(linearLayoutManager2);
        rcvChiTieu_khoanchi.setAdapter(chiTieuAdapter_chi);

        hienMucTieu();
        btnXem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hienMucTieu();
            }
        });
    }


    public void hienMucTieu(){
        int thang = Integer.parseInt(spthang.getSelectedItem().toString());
        int nam = Integer.parseInt(spnam.getSelectedItem().toString());

        mListChiTieu_khoanthu = ctService.getChiTieu(this,"Khoản thu", thang, nam);
        mListChiTieu_khoanchi = ctService.getChiTieu(this,"Khoản chi", thang, nam);

        chiTieuAdapter_thu.setData(mListChiTieu_khoanthu);
        chiTieuAdapter_chi.setData(mListChiTieu_khoanchi);



// Tính tổng thu vao
        long tongthu = 0;
        for (ChiTieuModel12 thuvao : mListChiTieu_khoanthu) {
            tongthu += thuvao.getChiPhi();
        }

// Đặt tổng số chi phí vào TextView
        thuvao.setText("Khoản chi ra : "+String.valueOf(tongthu));


// Tính tổng số chi ra
        long tongchi = 0;
        for (ChiTieuModel12 chiTieu : mListChiTieu_khoanchi) {
            tongchi += chiTieu.getChiPhi();
        }

// Đặt tổng số chi phí vào TextView
        chira.setText("Khoản chi ra : "+String.valueOf(tongchi));
// ngan sach thang
        long ngansach=tongthu-tongchi;
        ngansachthang.setText("Ngân sách tháng : "+String.valueOf(ngansach));
    }

    public void anhxaView(){
        ngansachthang=findViewById(R.id.ngansachthang);
        thuvao=findViewById(R.id.thuvao);
        chira = findViewById(R.id.chira);
        spthang = (Spinner) findViewById(R.id.spthang22);
        spnam = (Spinner) findViewById(R.id.spnam22);
        btnXem = findViewById(R.id.btbHienChiTieu);

        rcvChiTieu_khoanthu = findViewById(R.id.rcv_ChiTieuthu);
        rcvChiTieu_khoanchi = findViewById(R.id.rcv_ChiTieuChi);
    }

    public void initSpinners(){

        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //tháng năm hiện tại
        int thang = calendar.get(calendar.MONTH)+1;
        int nam = calendar.get(calendar.YEAR);

        //Spinner tháng
        ArrayAdapter<String> aa1 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Constraint.ARRAY_THANG);
        spthang.setAdapter(aa1);

        int positsion1 = aa1.getPosition(thang + "");
        spthang.setSelection(positsion1);


        //Spinner Năm
        ArrayAdapter aa2 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, Constraint.ARRAY_NAM);
        spnam.setAdapter(aa2);

        int positsion2 = aa2.getPosition(nam + "");
        spnam.setSelection(positsion2);

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
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}