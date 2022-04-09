package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    ArrayList<Integer> items = new ArrayList<Integer>();

    static final String ITEMS_KEY = "items";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ImageView imgDonat = (ImageView) findViewById(R.id.img_donat);
        final ImageView imgEsKrim = (ImageView) findViewById(R.id.img_es_krim);
        final ImageView imgKue = (ImageView) findViewById(R.id.img_kue);
        final FloatingActionButton fabAddItem = (FloatingActionButton) findViewById(R.id.fab_add_item);

        imgDonat.setOnClickListener(v -> {
            chooseItem("Donat", imgDonat);
        });
        imgEsKrim.setOnClickListener(v -> {
            chooseItem("Es Krim", imgEsKrim);
        });
        imgKue.setOnClickListener(v -> {
            chooseItem("Kue", imgKue);
        });

        fabAddItem.setOnClickListener(v -> {
            if(items.isEmpty()){
                Toast.makeText(this, "Tidak ada item yang dipilih", Toast.LENGTH_SHORT).show();
            }
            else {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putIntegerArrayListExtra(ITEMS_KEY, items);
                startActivity(intent);
            }
        });


    }

    private void chooseItem(String message, ImageView img) {
        if(!items.contains(img.getId())){
            items.add(img.getId());
            img.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.red));
            Toast.makeText(this, message + " Dipilih", Toast.LENGTH_SHORT).show();

        }else{
            items.remove((Integer) img.getId());
            img.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), android.R.color.transparent));
            Toast.makeText(this, message + " Batal Dipilih", Toast.LENGTH_SHORT).show();

        }
    }
}