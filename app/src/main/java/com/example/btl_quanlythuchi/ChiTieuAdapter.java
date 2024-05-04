package com.example.btl_quanlythuchi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.btl_quanlythuchi.Model.ChiTieuModel12;
import com.example.btl_quanlythuchi.Service.ChiTieuService;

import java.util.List;

public class ChiTieuAdapter extends RecyclerView.Adapter<ChiTieuAdapter.ChiTieuViewHolder> {
    private Context context;
    private List<ChiTieuModel12> mListChiTieu;
    public void setData(List<ChiTieuModel12> list){
        this.mListChiTieu = list;
        notifyDataSetChanged();
    }
    public ChiTieuAdapter(Context context) {
        this.context = context;
    }
    @NonNull
    @Override
    public ChiTieuAdapter.ChiTieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_thuchi, parent, false);
        return new ChiTieuAdapter.ChiTieuViewHolder(view);




    }

    @Override
    public void onBindViewHolder(@NonNull ChiTieuAdapter.ChiTieuViewHolder holder, int position) {
     ChiTieuModel12 chitieu=mListChiTieu.get(position);
     if(chitieu==null){
         return;
     }
        holder.tvHoatDong1.setText(chitieu.getHoatDong());
        holder.tvNgay1.setText(chitieu.getNgay()+"/"+chitieu.getThang() + "/"+chitieu.getNam());
        holder.tvDuKien1.setText(chitieu.getChiPhi() + "");
        holder.tvGhiChuMucTieu1.setText(chitieu.getGhiChu()+ "");
        holder.tvId1.setText(chitieu.getId()+"");
        ChiTieuService ctService = new ChiTieuService();

    }

    @Override
    public int getItemCount() {
        if(mListChiTieu!=null){
            return mListChiTieu.size();
        }
        return 0;
    }
    public static class ChiTieuViewHolder extends RecyclerView.ViewHolder {
        public TextView tvHoatDong1, tvNgay1, tvDuKien1, tvGhiChuMucTieu1, tvId1;

        public ChiTieuViewHolder(@NonNull View itemView) {
            super(itemView);
            tvHoatDong1 = itemView.findViewById(R.id.tvHoatDong_chitieu);
            tvNgay1 = itemView.findViewById(R.id.tvNgay_chitieu1);
            tvDuKien1 = itemView.findViewById(R.id.tvChiPhi_chitieu);
            tvGhiChuMucTieu1 = itemView.findViewById(R.id.tvGhiChu_chitieu);
            tvId1 = itemView.findViewById(R.id.tv_id_chitieu);
        }
    }


}
