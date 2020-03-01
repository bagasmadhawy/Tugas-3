package com.example.bungagila_;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvSanca;
    private ArrayList<Sanca> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvSanca = findViewById(R.id.activity_main);
        rvSanca.setHasFixedSize(true);
        list.addAll(SancaData.getSancaList());

        SancaAdapter sancaAdapter = new SancaAdapter(SancaData.getSancaList(), getApplicationContext());

        rvSanca.setLayoutManager(new LinearLayoutManager(this));
        rvSanca.setAdapter(sancaAdapter);
    }
}
