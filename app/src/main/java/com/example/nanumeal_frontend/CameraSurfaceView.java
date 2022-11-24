package com.example.nanumeal_frontend;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import androidx.annotation.NonNull;

public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    SurfaceHolder holder;
    Camera camera;

    public CameraSurfaceView(Context context) {
        super(context);
        init(context);
    }

    public CameraSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        //초기화를 위한 메소드
        holder = getHolder();
        holder.addCallback(this);
    }


    @Override
    public void surfaceCreated(@NonNull SurfaceHolder holder) {
        //만들어지는 시점
        camera = android.hardware.Camera.open();
        try {
            camera.setPreviewDisplay(holder);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void surfaceChanged(@NonNull SurfaceHolder holder, int i, int i1, int i2) {
        //변경
        camera.startPreview(); //렌즈로 부터 들어오는 영상을 뿌려줌
        camera.stopPreview();
        camera.setDisplayOrientation(90);//카메라 미리보기 오른쪽 으로 90 도회전
        camera.startPreview();

    }

    @Override
    public void surfaceDestroyed(@NonNull SurfaceHolder holder) {
        //소멸
        camera.stopPreview();//미리보기중지
        camera.release();
        camera = null;
    }

    public boolean capture(Camera.PictureCallback callback){
        if(camera != null){
            camera.takePicture(null,null,callback);
            return true;
        }
        else{
            return false;
        }
    }
}
