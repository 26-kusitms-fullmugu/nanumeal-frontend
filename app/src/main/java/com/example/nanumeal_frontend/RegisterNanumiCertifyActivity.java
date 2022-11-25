package com.example.nanumeal_frontend;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import android.Manifest;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.ContactsContract;
import android.provider.MediaStore;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.gun0912.tedpermission.PermissionListener;
import com.gun0912.tedpermission.normal.TedPermission;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


public class RegisterNanumiCertifyActivity extends AppCompatActivity {
    private AlertDialog dialog;
    private String mCurrentPhotoPath;
    private static final String TAG = "CertifyActivity";
    String userValue;
    Bitmap bitmap;
    private int Certify = 0;


    public static Bitmap StringToBitmap(String encodedString) { //Bitmap to String(Method)

        try {
            byte[] encodeByte = Base64.decode(encodedString, Base64.DEFAULT);
            Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
            return bitmap;
        } catch (Exception e) {
            e.getMessage();
            return null;
        }
    }

    private void captureCamera() { //카메라 불러오기 callback
        Intent intent1 = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        activityResultLauncher1.launch(intent1);

        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNanumiCertifyActivity.this);
        dialog = builder.setMessage("이 카드로 인증하시겠습니까?").setPositiveButton("회원가입 하러가기", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent1 = new Intent(RegisterNanumiCertifyActivity.this, RegisterNanumiInfoInput1Activity.class);
                userValue = "nanumi_certify";
                intent1.putExtra("userValue", userValue);
                startActivity(intent1);
                finish(); //이동

                Toast.makeText(getApplicationContext(), "서류 인증이 완료되었습니다.", Toast.LENGTH_SHORT);
            }
        }).create();
        dialog.show();


    }


    ActivityResultLauncher<Intent> activityResultLauncher1 = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() { //image 받아와서 띄우기
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK && result.getData() != null) {
                        Bundle extras = result.getData().getExtras();
                        bitmap = (Bitmap) extras.get("data");
                        Log.d("bitmap_width", String.valueOf(bitmap.getWidth()));
                        Log.d("bitmap_height", String.valueOf(bitmap.getHeight()));

                        ImageView cardIv = (ImageView) findViewById(R.id.register_nanumi_imageview);
                        cardIv.setImageBitmap(bitmap);
                        Certify = 1;


                    }
                }
            }
    );




    private void captureAlbum() { //앨범 불러오기 callback
        Log.d("certify", String.valueOf(Certify));
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
        intent.setAction(Intent.ACTION_PICK);
        activityResultLauncher.launch(intent);
        Uri uri = intent.getData();
        Log.d("uri", String.valueOf(uri));
        Certify = 1;
        Log.d("certify", String.valueOf(Certify));
        if(Certify == 1) {
            AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNanumiCertifyActivity.this);
            dialog = builder.setMessage("이 카드로 인증하시겠습니까?").setPositiveButton("회원가입 하러가기", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Intent intent1 = new Intent(RegisterNanumiCertifyActivity.this, RegisterNanumiInfoInput1Activity.class);
                    userValue = "nanumi_certify";
                    intent1.putExtra("userValue", userValue);
                    startActivity(intent1);
                    finish();
                }
            }).create();
            dialog.show();
        }
        else {
            Intent intent1 = new Intent(RegisterNanumiCertifyActivity.this, MainActivity.class);
            userValue = "nanumi_certify";
            intent1.putExtra("userValue", userValue);
            startActivity(intent1);
            finish();

        }

    }


    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            new ActivityResultCallback<ActivityResult>() { //image 받아와서 띄우기
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == RESULT_OK) {
                           Intent intent = result.getData();
                           Uri uri = intent.getData();
                        ImageView cardImage = (ImageView) findViewById(R.id.register_nanumi_imageview);
                        cardImage.setImageURI(uri);
                        Toast.makeText(getApplicationContext(), "서류 인증이 완료되었습니다.", Toast.LENGTH_SHORT);

                    }
                }
            }
    );




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

                case R.id.register_certify_select_next_tv: //건너뛰기
                    Intent view2 = new Intent(RegisterNanumiCertifyActivity.this, RegisterNanumiInfoInput1Activity.class);
                    userValue = "nanumi";
                    view2.putExtra("userValue", userValue);
                    startActivity(view2);
                    Log.d("moveActivity", "Certify to NoCertifyActivity");
                    finish();
                    break;

                case R.id.register_certify_select_btn_album:
                    captureAlbum();
                    break;

                case R.id.register_certify_select_btn_camera:
                    captureCamera();
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