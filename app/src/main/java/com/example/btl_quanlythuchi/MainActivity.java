package com.example.btl_quanlythuchi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Database;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.btl_quanlythuchi.Constraint.Constraint;
import com.example.btl_quanlythuchi.Database.NguoiDungDAO;
import com.example.btl_quanlythuchi.Database.NguoiDungDB;
import com.example.btl_quanlythuchi.Model.NguoiDungModel;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    TextView tv_ten, tv_sodu;

    ImageButton btnSua;
    Button btnGhiChiTieu, btnGhiMucTieu, btnThongKeMucTieu, btnThongKeThuChi;

    NguoiDungModel nguoiDung = new NguoiDungModel(1, "", 0);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        anhxa();

        hienThiNguoiDung();

        View.OnClickListener navigateClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String action = "";
                Class<?> destinationActivity = null;
                if(view.getId() == R.id.btnGhiChiTieu){
                    action = Constraint.ACTION_THEM_MOI;
                    destinationActivity = KhoanThuChi.class;
                }else if(view.getId() == R.id.btnGhiMucTieu){
                    action = Constraint.ACTION_THEM_MOI;
                    destinationActivity = MucTieu.class;
                }else if(view.getId() == R.id.btnThongKeMucTieu){
                    action = "Thong_Ke_MucTieu";
                    destinationActivity = ThongKeMucTieu.class;
                }else if(view.getId() == R.id.btnThongKeThuChi){
                    action = "Thong_Ke_Thu_Chi";
                    destinationActivity = ThongKeThuChi.class;
                }else if(view.getId() == R.id.btn_sua){
                    action = "Sua_Nguoi_Dung";
                    destinationActivity = NguoiDung.class;
                }

                if(destinationActivity != null){
                    Intent intent = new Intent(MainActivity.this, destinationActivity);
                    intent.putExtra("action", action);
                    startActivity(intent);
                }

            }
        };

        btnSua.setOnClickListener(navigateClickListener);
        btnGhiChiTieu.setOnClickListener(navigateClickListener);
        btnGhiMucTieu.setOnClickListener(navigateClickListener);
        btnThongKeMucTieu.setOnClickListener(navigateClickListener);
        btnThongKeThuChi.setOnClickListener(navigateClickListener);


    }

    @Override
    protected void onResume() {
        super.onResume();

        hienThiNguoiDung();
    }

    void anhxa(){
        btnGhiChiTieu = findViewById(R.id.btnGhiChiTieu);
        btnGhiMucTieu = findViewById(R.id.btnGhiMucTieu);
        btnThongKeMucTieu = findViewById(R.id.btnThongKeMucTieu);
        btnThongKeThuChi = findViewById(R.id.btnThongKeThuChi);
        btnSua = findViewById(R.id.btn_sua);
        tv_ten = findViewById(R.id.tv_ten);
        tv_sodu = findViewById(R.id.tv_sodu);
    }


    void hienThiNguoiDung(){
        List<NguoiDungModel> listNguoiDung = NguoiDungDB.getInstance(this).nguoiDungDAO().getListNguoiDung();

        if(listNguoiDung == null || listNguoiDung.isEmpty()){
            nguoiDung = new NguoiDungModel(1, "Người dùng 1", 0);
            NguoiDungDB.getInstance(this).nguoiDungDAO().insertNguoiDung(nguoiDung);
        }else{
            nguoiDung = listNguoiDung.get(0);
        }

        tv_ten.setText("Tên: " + nguoiDung.getTen());
        tv_sodu.setText("Số dư: "+ nguoiDung.getSoDu());

    }


}