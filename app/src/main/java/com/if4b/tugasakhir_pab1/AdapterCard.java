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

    public interface OnItemClickCallBack{
        void onItemClicked(ModelKaraoke data);
    }

    private AdapterCard.OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(AdapterCard.OnItemClickCallBack callBack) {
        this.callBack = callBack;
    }

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
    holder.tvtempat.setText(karaoke.getTempat());

    Glide
            .with(holder.itemView.getContext())
            .load(karaoke.getFoto())
            .into(holder.ivfototempatkaraoke);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                callBack.onItemClicked(datakaraoke.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return datakaraoke.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
        ImageView ivfototempatkaraoke;
        TextView tvnamakaraoke,tvtempat;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);
            ivfototempatkaraoke = itemView.findViewById(R.id.iv_foto_karaoke);
            tvnamakaraoke = itemView.findViewById(R.id.tv_nama_tempat_karaoke);
            tvtempat = itemView.findViewById(R.id.tv_tempat);
        }


    }
}
