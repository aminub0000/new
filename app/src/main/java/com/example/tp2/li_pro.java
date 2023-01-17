package com.example.tp2;

import android.app.Application;

import java.util.ArrayList;

public class li_pro extends Application {
    ArrayList<produit> list_product;

    public void onCreate() {
        super.onCreate();
        list_product = initData();
    }

    public ArrayList<produit> initData() {
        final String[] produit = getResources().getStringArray(R.array.list_produit);
        final String[] prix = getResources().getStringArray(R.array.list_prix);
        ArrayList<produit> li = new ArrayList<>();

        for (int i = 0; i < produit.length; ++i) {
            li.add(new produit( produit[i] , Float.parseFloat(prix[i])));
        }
        return li;
    }
}
