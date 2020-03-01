package com.example.bungagila_;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class SancaAdapter extends RecyclerView.Adapter<SancaAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Sanca> sancaList;

    public SancaAdapter(ArrayList<Sanca> sancaList, Context context) {
        this.context = context;
    }

    public ArrayList<Sanca> getSancaList() {
        return sancaList;
    }

    public void setSancaList(ArrayList<Sanca> sancaList) {
        this.sancaList = sancaList;
    }

    @NonNull
    @Override
    public SancaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View itemRow = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_sanca, parent, false);
        return new ViewHolder(itemRow);
    }

    @Override
    public void onBindViewHolder(@NonNull SancaAdapter.ViewHolder holder, final int i) {
        Glide.with(context).load(SancaData.getSancaList().get(i).getGambarSanca()).into(holder.ivSanca);
        holder.tvNama.setText(SancaData.getSancaList().get(i).getNamaSanca());
        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, SancaDetail.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("img_url", SancaData.getSancaList().get(i).getGambarSanca());
                intent.putExtra("title", SancaData.getSancaList().get(i).getNamaSanca());
                intent.putExtra("detail", SancaData.getSancaList().get(i).getDetailSanca());
                context.startActivity(intent);

            }
        });

        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setType("text/plain");
                String namaSanca = "Nama : " + SancaData.getSancaList().get(i).getNamaSanca();
                intent.putExtra(Intent.EXTRA_TEXT, namaSanca);
                context.startActivity(Intent.createChooser(intent, "Kirim"));
            }
        });
    }

    @Override
    public int getItemCount() {
        return SancaData.getSancaList().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ivSanca;
        TextView tvNama;
        Button btnShare, btnView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ivSanca = itemView.findViewById(R.id.itemsanca_iv);
            tvNama = itemView.findViewById(R.id.itemsanca_tv_nama);
            btnShare = itemView.findViewById(R.id.itemsanca_btn_share);
            btnView = itemView.findViewById(R.id.itemsanca_btn_view);
        }
    }
}
