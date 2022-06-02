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

public class AdapterGrid extends RecyclerView.Adapter<AdapterGrid.GridViewHolder> {
    private ArrayList<ModelKaraoke> datakaraoke;

    public AdapterGrid(ArrayList<ModelKaraoke> datakaraoke) {this.datakaraoke = datakaraoke; }

     //Call Back
     public interface OnItemClickCallBack{
         void onItemClicked(ModelKaraoke data);
     }

    private OnItemClickCallBack callBack;
    public void setOnItemClickCallBack(OnItemClickCallBack callBack) {
        this.callBack = callBack;
    }


    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_item_karaoke, parent, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GridViewHolder holder, int position) {
        ModelKaraoke karaoke = datakaraoke.get(position);

        Glide
                .with(holder.itemView.getContext())
                .load(karaoke.getFoto())
                .into(holder.ivgridtempatkaraoke);

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

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView ivgridtempatkaraoke;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            ivgridtempatkaraoke = itemView.findViewById(R.id.iv_grid_tempat_karaoke);

        }
    }
}
