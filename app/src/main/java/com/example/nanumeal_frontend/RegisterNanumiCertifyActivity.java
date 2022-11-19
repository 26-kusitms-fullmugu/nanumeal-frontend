package com.example.nanumeal_frontend;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

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
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegisterNanumiCertifyActivity extends AppCompatActivity {

    private String mCurrentPhotoPath;
    private static final String TAG = "CertifyActivity";

    private void captureCamera() { //카메라 촬영 액티비티
        Intent takePictureIntent = new Intent(RegisterNanumiCertifyActivity.this, NanumiCertifyCameraActivity.class);

        //camera activity 확인
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            File photoFile = null; //저장할 파일 생성

            try {
                File tempDir = getCacheDir();

                //임시 촬영 파일 세팅
                String timeStamp = new SimpleDateFormat("yyyyMMdd").format(new Date());
                String imageFileName = "Certify__" + timeStamp + "__"; // ex) Certify__20221119__

                File tempImage = File.createTempFile(imageFileName, ".jpg", tempDir);

                mCurrentPhotoPath = tempImage.getAbsolutePath();
                photoFile = tempImage;

            } catch (IOException e) {
                Log.e(TAG, "file making error", e);
            }
            if (photoFile != null) {
                Uri PhotoURI = FileProvider.getUriForFile(this, getPackageName()+".fileprovider", photoFile);
                takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, PhotoURI);
                startActivity(takePictureIntent);
            }
        }
    }


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
                    captureCamera();
                    break;

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