package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    Button btn_edit;
    EditText txt_produit;
    EditText txt_prix;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btn_edit = findViewById(R.id.btn_edit);
        txt_produit = findViewById(R.id.txt_produit);
        txt_prix = findViewById(R.id.txt_prix);


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(btn_edit.getText().toString()) || TextUtils.isEmpty(txt_prix.getText().toString()) ){
                    Toast.makeText(MainActivity2.this, "check you info", Toast.LENGTH_SHORT).show();
                    return;
                }
                int index = getIntent().getIntExtra("index",-1);
                Intent it = new Intent();
                it.putExtra("index",index);
                it.putExtra("produit",txt_produit.getText().toString());
                it.putExtra("prix",Float.parseFloat(txt_prix.getText().toString()));
                setResult(2 , it);
                finish();
            }
        });



    }
}