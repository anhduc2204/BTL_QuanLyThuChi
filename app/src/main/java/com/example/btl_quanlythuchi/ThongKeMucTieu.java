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

import com.example.btl_quanlythuchi.Constraint.Constraint;
import com.example.btl_quanlythuchi.Model.MucTieuModel;
import com.example.btl_quanlythuchi.Service.MucTieuService;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class ThongKeMucTieu extends AppCompatActivity {

    Spinner spthang, spnam;
    Button btnXem;
    RecyclerView rcvMucTieu_khoanthu, rcvMucTieu_khoanchi;

    MucTieuAdapter mucTieuAdapter_thu;
    MucTieuAdapter mucTieuAdapter_chi;
    List<MucTieuModel> mListMucTieu_khoanthu;
    List<MucTieuModel> mListMucTieu_khoanchi;

    MucTieuService mtService = new MucTieuService();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thong_ke_muc_tieu);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar4);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        anhxaView();
        initSpinners();

        // mục tiêu khoản thu
        mucTieuAdapter_thu = new MucTieuAdapter(this);
        mListMucTieu_khoanthu = new ArrayList<>();
        mucTieuAdapter_thu.setData(mListMucTieu_khoanthu);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        rcvMucTieu_khoanthu.setLayoutManager(linearLayoutManager1);
        rcvMucTieu_khoanthu.setAdapter(mucTieuAdapter_thu);

        //mục tiêu khoản chi
        mucTieuAdapter_chi = new MucTieuAdapter(this);
        mListMucTieu_khoanchi = new ArrayList<>();
        mucTieuAdapter_chi.setData(mListMucTieu_khoanchi);

        LinearLayoutManager linearLayoutManager2 = new LinearLayoutManager(this);
        rcvMucTieu_khoanchi.setLayoutManager(linearLayoutManager2);
        rcvMucTieu_khoanchi.setAdapter(mucTieuAdapter_chi);

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

        mListMucTieu_khoanthu = mtService.getMucTieu(this,"Khoản thu", thang, nam);
        mListMucTieu_khoanchi = mtService.getMucTieu(this,"Khoản chi", thang, nam);

        mucTieuAdapter_thu.setData(mListMucTieu_khoanthu);
        mucTieuAdapter_chi.setData(mListMucTieu_khoanchi);

    }


    public void anhxaView(){
        spthang = (Spinner) findViewById(R.id.spthang22);
        spnam = (Spinner) findViewById(R.id.spnam22);
        btnXem = findViewById(R.id.btnHienMucTieu);

        rcvMucTieu_khoanthu = findViewById(R.id.rcv_MucTieuThu);
        rcvMucTieu_khoanchi = findViewById(R.id.rcv_MucTieuChi);
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

    //toolbar
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == android.R.id.home){
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}