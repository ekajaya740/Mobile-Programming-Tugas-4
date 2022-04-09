package com.example.tugas4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class OrderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        ArrayList<Integer> items = intent.getIntegerArrayListExtra(MainActivity.ITEMS_KEY);

        final ImageView imgDonat = (ImageView) findViewById(R.id.img_donat);
        final ImageView imgEsKrim = (ImageView) findViewById(R.id.img_es_krim);
        final ImageView imgKue = (ImageView) findViewById(R.id.img_kue);

        Objects.requireNonNull(getSupportActionBar()).setTitle("Halaman Order");

        if (!items.contains(imgDonat.getId())) {
            imgDonat.setVisibility(View.GONE);
        }

        if (!items.contains(imgEsKrim.getId())) {
            imgEsKrim.setVisibility(View.GONE);
        }

        if (!items.contains(imgKue.getId())) {
            imgKue.setVisibility(View.GONE);
        }


    }
}