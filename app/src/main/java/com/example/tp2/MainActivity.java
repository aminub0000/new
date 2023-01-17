package com.example.tp2;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    String[] values = { "Stream", "My Lists", "My Searches", "Trends" };
    ArrayAdapter<produit> adapter;
    ArrayList<produit> produits;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        li_pro context = (li_pro) this.getApplicationContext();
        produits =context.initData();
        adapter = new ArrayAdapter<produit>(this , android.R.layout.simple_list_item_1,
                android.R.id.text1, produits);
        setListAdapter(adapter);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent it = new Intent(MainActivity.this , MainActivity2.class);
        it.putExtra("index" , position);
        startActivityForResult(it , 2);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ( requestCode == 2){
            int index =  data.getIntExtra("index" , -1) ;
            String produit = data.getStringExtra("produit");
            float prix = data.getFloatExtra("prix" , 0.0f) ;
            produits.get(index).produit=produit;
            produits.get(index).p_prix=prix;
            setListAdapter(adapter);

        }
    }
}