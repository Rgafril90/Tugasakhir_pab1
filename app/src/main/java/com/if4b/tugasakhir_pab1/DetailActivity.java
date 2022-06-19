package com.if4b.tugasakhir_pab1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    private TextView tvnama,tvtempat,tvdetail,tvnotelp;
    private ImageView ivfoto;
    private String yNama,yTempat,yDetail,yNotelp,yFoto;

    private Button btnBukaTelepon,btnBukaLokasi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

//        toolbar edit back
        Toolbar toolbar = findViewById(R.id.app_bar);
        setSupportActionBar(toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
//end toolbar

        initView();

        Intent terima = getIntent();
        yNama = terima.getStringExtra("xNama");
        yTempat = terima.getStringExtra("xTempat");
        yDetail = terima.getStringExtra("xDetail");
        yNotelp = terima.getStringExtra("xNoTelp");
        yFoto = terima.getStringExtra("xFoto");

        tvnama.setText(yNama);
        tvtempat.setText(yTempat);
        tvdetail.setText(yDetail);
        tvnotelp.setText(yNotelp);


        Glide.with(DetailActivity.this)
                .load(yFoto)
                .into(ivfoto);

        // btn lokasi
        btnBukaLokasi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Lokasi = tvnama.getText().toString();
                Uri uriLokasi = Uri.parse("geo:0,0?q=" + Lokasi);
                Intent bukaLokasi = new Intent(Intent.ACTION_VIEW,uriLokasi);
                startActivity(bukaLokasi);
            }
        });

        // BTN Telepon
        btnBukaTelepon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Telepon = tvnotelp.getText().toString();
                Intent bukaTelepon = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel",Telepon, null));
                startActivity(bukaTelepon);
            }
        });
    }


    private void initView() {
        tvnama = findViewById(R.id.tv_nama_Karaoke);
        tvtempat = findViewById(R.id.tv_tempat);
        tvdetail = findViewById(R.id.tv_detail_Karaoke);
        tvnotelp = findViewById(R.id.tv_no_telp);
        ivfoto = findViewById(R.id.iv_foto);
        btnBukaLokasi = findViewById(R.id.btn_lokasi);
        btnBukaTelepon = findViewById(R.id.btn_telepon);
    }
}