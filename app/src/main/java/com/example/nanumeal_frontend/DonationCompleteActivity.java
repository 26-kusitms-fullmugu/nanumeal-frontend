package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class DonationCompleteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donation_complete);

        Button go_home_btn = (Button) findViewById(R.id.go_home_btn);
        Button donation_certify_btn = (Button) findViewById(R.id.donation_certify_btn);

        go_home_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DonationCompleteActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

        donation_certify_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(DonationCompleteActivity.this, MyNanumerHistoryActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}