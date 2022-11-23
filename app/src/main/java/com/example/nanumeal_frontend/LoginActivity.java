package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {


    class selectListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_signUp_tv:
                    Intent intent = new Intent(LoginActivity.this, RegisterSelectActivity.class);
                    startActivity(intent);
                    finish();
                    break;

                case R.id.login_login_btn:
//                    getLogin();
//                      break;
                case R.id.login_kakao:
//                    getLoginWithKaKao();
//                    break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        selectListener selectListener = new selectListener();
        TextView SignUpTv = (TextView) findViewById(R.id.login_signUp_tv);
        SignUpTv.setOnClickListener(selectListener);
    }
}