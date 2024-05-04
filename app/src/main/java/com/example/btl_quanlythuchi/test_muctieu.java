package com.example.btl_quanlythuchi;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;

public class test_muctieu extends AppCompatActivity {
    Spinner spthang, spnam, spthuchi, sphd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test2);
        Toolbar toolbar = findViewById(R.id.toolbar2);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        spthang = (Spinner) findViewById(R.id.spthang22);
        final ArrayList<String> arraythang = new ArrayList<String>();
        arraythang.add("1");
        arraythang.add("2");
        arraythang.add("3");
        arraythang.add("4");
        arraythang.add("5");
        arraythang.add("6");
        arraythang.add("7");
        arraythang.add("8");
        arraythang.add("9");
        arraythang.add("10");
        arraythang.add("11");
        arraythang.add("12");

        ArrayAdapter<String> aa1 = new ArrayAdapter<>(this,
                androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraythang);

        spthang.setAdapter(aa1);
        spthang.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(test_muctieu.this, arraythang.get(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        spnam = (Spinner) findViewById(R.id.spnam22);
        final ArrayList<String> arraynam = new ArrayList<String>();
        arraynam.add("2022");
        arraynam.add("2023");
        arraynam.add("2024");
        arraynam.add("2025");
        arraynam.add("2026");
        arraynam.add("2027");
        arraynam.add("2028");
        arraynam.add("2029");
        arraynam.add("2030");
        arraynam.add("2031");
        arraynam.add("2032");
        arraynam.add("2034");

        ArrayAdapter aa2 = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, arraynam);
        spnam.setAdapter(aa2);
        //spinner hoatdong

        // Spinner sphd
        sphd = (Spinner) findViewById(R.id.sphd1);
        final ArrayList<String> arrayhd = new ArrayList<String>();
        arrayhd.add("Lương");
        arrayhd.add("Làm thêm");
        arrayhd.add("Học bổng");
        arrayhd.add("Ăn uống");
        arrayhd.add("Du lịch");
        arrayhd.add("Sức khỏe");
        arrayhd.add("Gia đình");
        arrayhd.add("Giải Trí");
        arrayhd.add("Hẹn hò");
        arrayhd.add("Khác");

        ArrayAdapter<String> aa3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arrayhd);
        sphd.setAdapter(aa3);

// Spinner spthuchi
        spthuchi = (Spinner) findViewById(R.id.spthuchi1);
        final ArrayList<String> arraythuchi = new ArrayList<String>();
        arraythuchi.add("Khoản thu");
        arraythuchi.add("Khoản chi");

        ArrayAdapter<String> aa4 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, arraythuchi);
        spthuchi.setAdapter(aa4);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
    }
}