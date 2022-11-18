package com.example.nanumeal_frontend;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

public class RegisterNanumiCertifyActivity extends AppCompatActivity {


    class selectListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.register_certify_select_ex_tv:
                    Intent view1 = new Intent(RegisterNanumiCertifyActivity.this, RegisterSelectActivity.class);
                    startActivity(view1);
                    finish();
                    Log.d("moveActivity", "Certify to Select");
                    break;

                case R.id.register_certify_select_next_tv:
                    Intent view2 = new Intent(RegisterNanumiCertifyActivity.this, MainActivity.class);
                    startActivity(view2);
                    Log.d("moveActivity", "Certify to MainActivity");
                    finish();
                    break;

                case R.id.register_certify_select_btn_album:


                case R.id.register_certify_select_btn_camera:
                    Intent view3 = new Intent(RegisterNanumiCertifyActivity.this, NanumiCertifyCameraActivity.class);
                    startActivity(view3);
                    Log.d("moveActivity", "Certify to CertifyCamera");
                    break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nanumi_certify);

        //화면구성
        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));




        //리스너 부착
        selectListener onClickListener = new selectListener();
        TextView nextTv = (TextView) findViewById(R.id.register_certify_select_next_tv);
        nextTv.setOnClickListener(onClickListener);

        TextView exTv = (TextView) findViewById(R.id.register_certify_select_ex_tv);
        exTv.setOnClickListener(onClickListener);

        ImageButton cameraBtn = (ImageButton) findViewById(R.id.register_certify_select_btn_camera);
        cameraBtn.setOnClickListener(onClickListener);

        ImageButton albumBtn = (ImageButton) findViewById(R.id.register_certify_select_btn_album);
        albumBtn.setOnClickListener(onClickListener);


    }
}