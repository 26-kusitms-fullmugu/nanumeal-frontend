package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class EatRegistrationActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eat_registration);

        ImageView eat_bottom_btn = (ImageView) findViewById(R.id.eat_bottom_btn);

        eat_bottom_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(EatRegistrationActivity.this, MessageScrollActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}