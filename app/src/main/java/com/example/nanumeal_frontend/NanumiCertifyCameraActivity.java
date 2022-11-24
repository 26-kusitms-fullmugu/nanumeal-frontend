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
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.hardware.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.lang.reflect.Field;

public class NanumiCertifyCameraActivity extends AppCompatActivity {
    private final static int REQUEST_PERMISSION = 1000;
    CameraSurfaceView surfaceView;
    String intentBitmap;

    private void captureBtn() {
        surfaceView.capture(new Camera.PictureCallback() {
            @Override
            public void onPictureTaken(byte[] data, Camera camera) {
                //bytearray 형식으로 전달
                //이걸이용해서 이미지뷰로 보여주거나 파일로 저장
                camera.startPreview();
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inSampleSize = 8; // 1/8사이즈로 보여주기
                Bitmap bitmap = BitmapFactory.decodeByteArray(data, 0, data.length); //data 어레이 안에 있는 데이터 불러와서 비트맵에 저장
                intentBitmap = String.valueOf(bitmap);
                Log.d("Bitmap", intentBitmap);

                Intent intent = new Intent(NanumiCertifyCameraActivity.this, RegisterNanumiCertifyActivity.class);
                intent.putExtra("Bitmap", bitmap);
                startActivity(intent);
                finish();;
            }
        });
    }

    class ClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            if(v.getId() == R.id.certify_camera_btn) {
                captureBtn(); //버튼 누르면 촬영
            }
        }
    }


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
            Toast.makeText(this, "카메라 권한 사용자가 승인함",Toast.LENGTH_SHORT).show();
        }

        Button button = (Button) findViewById(R.id.certify_camera_btn);
        ClickListener clickListener = new ClickListener();
        button.setOnClickListener(clickListener);

    }


}