package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MapStoreDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map_store_detail);

        ImageView eat_bottom_btn = (ImageView) findViewById(R.id.eat_bottom_btn);
        ImageView store_book_mark = (ImageView) findViewById(R.id.store_book_mark);
        ImageView store_book_mark_fill = (ImageView) findViewById(R.id.store_book_mark_fill);


        eat_bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(MapStoreDetailActivity.this, EatRegistrationActivity.class);
                startActivity(intent);
                finish();
            }
        });

        store_book_mark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                store_book_mark.setVisibility(View.INVISIBLE);
                store_book_mark_fill.setVisibility(View.VISIBLE);
            }
        });

        store_book_mark_fill.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                store_book_mark_fill.setVisibility(View.INVISIBLE);
                store_book_mark.setVisibility(View.VISIBLE);
            }
        });

    }

}