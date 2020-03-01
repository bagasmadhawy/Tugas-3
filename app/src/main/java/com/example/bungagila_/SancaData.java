package com.example.bungagila_;

import java.util.ArrayList;

public class SancaData {
    private static String[] namaSanca = {
            "Reticulated Python",
            "Blood Python",
            "Ball Python",
            "Green Tree Python",
            "Molurus Python",
            "Water Python",
            "Boelens Python"
    };

    private static String[] detailSanca = {
            "Sanca Kembang",
            "Sanca Darah",
            "Sanca Bola",
            "Sanca Pohon Hijau",
            "Sanca Bodo",
            "Sanca Air",
            "Sanca Bulan"
    };

    private static int[] gambarSanca = {
            R.drawable.retic,
            R.drawable.dipong,
            R.drawable.bp,
            R.drawable.gtp,
            R.drawable.molu,
            R.drawable.pelangi,
            R.drawable.sb
    };

    public static ArrayList<Sanca> getSancaList() {
        Sanca sanca = null;
        ArrayList<Sanca> list = new ArrayList<>();

        for (int i = 0; i < namaSanca.length; i++) {
            sanca = new Sanca();
            sanca.setNamaSanca(namaSanca[i]);
            sanca.setDetailSanca(detailSanca[i]);
            sanca.setGambarSanca(gambarSanca[i]);
            list.add(sanca);
        }
        return list;
    }
}
