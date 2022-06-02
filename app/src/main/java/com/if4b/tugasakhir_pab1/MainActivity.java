package com.if4b.tugasakhir_pab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvkaraoke;
    private ArrayList<ModelKaraoke> data = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvkaraoke = findViewById(R.id.rv_karaoke);
        rvkaraoke.setHasFixedSize(true);

        data.addAll(DataTempatKaraoke.ambilDataTempatKaraoke());
        tampilDataCard();
    }

    private void tampilDataCard() {
        rvkaraoke.setLayoutManager(new LinearLayoutManager(this));
        AdapterCard colokanCard = new AdapterCard(data);
        rvkaraoke.setAdapter(colokanCard);

        colokanCard.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelKaraoke data) {
                Intent pindah = new Intent(MainActivity.this, DetailActivity.class);
                pindah.putExtra("xNama", data.getNama());
                pindah.putExtra("xTempat",data.getTempat());
                pindah.putExtra("xDetail", data.getDetail());
                pindah.putExtra("xNoTelp",data.getNoTelp());
                pindah.putExtra("xFoto",data.getFoto());
                startActivity(pindah);
            }
        });

    }

    private void tampilDataGrid(){
        rvkaraoke.setLayoutManager(new GridLayoutManager(this,2));
        AdapterGrid colokanGrid = new AdapterGrid(data);
        rvkaraoke.setAdapter(colokanGrid);

        colokanGrid.setOnItemClickCallBack(new AdapterGrid.OnItemClickCallBack() {
            @Override
            public void onItemClicked(ModelKaraoke data) {
                Toast.makeText(MainActivity.this, "Nama Tempat Karaoke" + data.getNama(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}