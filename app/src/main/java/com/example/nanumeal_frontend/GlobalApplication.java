package com.example.nanumeal_frontend;

import android.app.Application;

//import com.kakao.sdk.common.KakaoSdk;

public class GlobalApplication extends Application {
    private static GlobalApplication instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

//        KakaoSdk.init(this,"d4f59408dc6da548bfe2a267706b83e6");
    }

}
