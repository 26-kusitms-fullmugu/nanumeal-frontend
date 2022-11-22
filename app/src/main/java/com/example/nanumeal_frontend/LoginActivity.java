package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class LoginActivity extends AppCompatActivity {

    class selectListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
}