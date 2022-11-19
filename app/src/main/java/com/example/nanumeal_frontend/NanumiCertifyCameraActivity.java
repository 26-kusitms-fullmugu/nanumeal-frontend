package com.example.nanumeal_frontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.Window;
import android.view.WindowManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class NanumiCertifyCameraActivity extends AppCompatActivity {
    private final static int REQUEST_PERMISSION = 1000;


//    private void saveImg() {
//        try {
//            File storageDir = new File(getFilesDir() + "/capture");
//            if(!storageDir.exists()) {
//                storageDir.mkdirs();
//            }
//            filename = "캡쳐파일" + ".jpg";
//
//            File file = new File(storageDir, filename);
//            boolean deleted = file.delete();
//            Log.w(TAG,"Delete Dup Check : " + deleted);
//            FileOutputStream output = null;
//
//            try {
//                output = new FileOutputStream(file);
//                Bitmap bitmap = (BitmapDrawable)
//
//
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nanumi_certify_camera);

        Window window = getWindow();
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN); //카메라 풀 스크린

        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                != PackageManager.PERMISSION_GRANTED) {
            //권한 요청 코드
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_PERMISSION);
        } else {
            //권한 OK시 실행할 코드


        }
    }


}