package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

public class SignUpFinishActivity extends AppCompatActivity {
    String userValue;

    class clickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.sign_up_finish_btn) {
                Intent intent = new Intent(SignUpFinishActivity.this, MainActivity.class);
                intent.putExtra("userValue", userValue);
                startActivity(intent);
                overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up_finish);

        Intent intent = getIntent();
        userValue = intent.getStringExtra("userValue");
        Log.d("userValue", userValue);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));

        clickListener onClickListener = new clickListener();
        Button nextBtn = (Button) findViewById(R.id.sign_up_finish_btn);

        nextBtn.setOnClickListener(onClickListener);


    }
}