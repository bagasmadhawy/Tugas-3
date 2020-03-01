package com.example.bungagila_;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class SancaDetail extends AppCompatActivity {

    ImageView ivDetail;
    TextView tvNamaDetail, tvDesDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sanca_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ivDetail = findViewById(R.id.detailsanca_iv);
        tvNamaDetail = findViewById(R.id.detailsanca_tv_nama);
        tvDesDetail = findViewById(R.id.detailsanca_tv_deskripsi);

        getIncomingIntent();
    }

    private void getIncomingIntent() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            int getImg = bundle.getInt("img_url");
            Glide.with(getApplicationContext()).load(getImg).into(ivDetail);
            String getName = bundle.getString("title");
            String getDesc = bundle.getString("detail");

            tvNamaDetail.setText(getName);
            tvDesDetail.setText(getDesc);
        } else {
            Toast.makeText(this, "No Data", Toast.LENGTH_SHORT).show();
        }
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                Intent intent = new Intent(this, MainActivity.class);
                startActivity(intent);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
