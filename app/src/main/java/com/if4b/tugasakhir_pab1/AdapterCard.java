package com.if4b.tugasakhir_pab1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class AdapterCard extends RecyclerView.Adapter<AdapterCard.CardViewHolder> {
    private ArrayList<ModelKaraoke> datakaraoke;

    public AdapterCard(ArrayList<ModelKaraoke> datakaraoke) {this.datakaraoke = datakaraoke; }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item_karaoke, parent, false);
        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCard.CardViewHolder holder, int position) {
    ModelKaraoke karaoke = datakaraoke.get(position);

    holder.tvnamakaraoke.setText(karaoke.getNama());
    holder.tvdetailkaraoke.setText(karaoke.getDetail());

    Glide
            .with(holder.itemView.getContext())
            .load(karaoke.getFoto())
            .into(holder.ivfototempatkaraoke);
    }

    @Override
    public int getItemCount() {
        return datakaraoke.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView ivfototempatkaraoke;
        TextView tvnamakaraoke, tvdetailkaraoke;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivfototempatkaraoke = itemView.findViewById(R.id.iv_foto_karaoke);
            tvnamakaraoke = itemView.findViewById(R.id.tv_nama_tempat_karaoke);
            tvdetailkaraoke = itemView.findViewById(R.id.tv_tentang_Karaoke);

        }


    }
}
