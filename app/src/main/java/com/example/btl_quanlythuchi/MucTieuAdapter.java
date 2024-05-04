package com.example.btl_quanlythuchi;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.btl_quanlythuchi.Model.MucTieuModel;
import com.example.btl_quanlythuchi.Service.ChiTieuService;

import java.util.List;

public class MucTieuAdapter extends RecyclerView.Adapter<MucTieuAdapter.MucTieuViewHolder> {

    private Context context;
    private List<MucTieuModel> mListMucTieu;

    public void setData(List<MucTieuModel> list){
        this.mListMucTieu = list;
        notifyDataSetChanged();
    }

    public MucTieuAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public MucTieuViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_muctieu, parent, false);
        return new MucTieuViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MucTieuAdapter.MucTieuViewHolder holder, int position) {
        MucTieuModel mucTieu = mListMucTieu.get(position);
        if(mucTieu == null){
            return;
        }
        holder.tvHoatDong.setText(mucTieu.getHoatDong());
        holder.tvNgay.setText(mucTieu.getThang() + "/"+ mucTieu.getNam());
        holder.tvDuKien.setText(mucTieu.getChiPhiDuKien() + "");
        holder.tvGhiChuMucTieu.setText(mucTieu.getGhiChu()+ "");
        holder.tvId.setText(mucTieu.getId()+"");
        ChiTieuService ctService = new ChiTieuService();
        long chiPhiThucTe = ctService.getTongChiTieu(context, mucTieu.getLoai(),
                mucTieu.getHoatDong(), mucTieu.getThang(), mucTieu.getNam());
        holder.tvThucTe.setText(chiPhiThucTe + "");

    }


    @Override
    public int getItemCount() {
        if(mListMucTieu != null){
            return mListMucTieu.size();
        }
        return 0;
    }

    public class MucTieuViewHolder extends RecyclerView.ViewHolder{

        private TextView tvHoatDong, tvNgay, tvGhiChuMucTieu, tvDuKien, tvThucTe, tvId;

        public MucTieuViewHolder(@NonNull View itemView) {
            super(itemView);

            tvHoatDong = itemView.findViewById(R.id.tvHoatDong_muctieu);
            tvNgay = itemView.findViewById(R.id.tvNgay_muctieu);
            tvDuKien = itemView.findViewById(R.id.tvDuKien);
            tvThucTe = itemView.findViewById(R.id.tvThucTe);
            tvGhiChuMucTieu = itemView.findViewById(R.id.tvGhiChu_muctieu);
            tvId = itemView.findViewById(R.id.tv_id_muctieu);


        }
    }

}
