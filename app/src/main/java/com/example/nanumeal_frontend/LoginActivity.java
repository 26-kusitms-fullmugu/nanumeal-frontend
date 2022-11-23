package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kakao.sdk.auth.model.OAuthToken;
import com.kakao.sdk.user.UserApiClient;
import com.kakao.sdk.user.model.Account;
import com.kakao.sdk.user.model.User;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;

import kotlin.Unit;
import kotlin.jvm.functions.Function2;

public class LoginActivity extends AppCompatActivity {
    public ArrayList<String> LoginValue;
    String kakaoId, kakaoName, kakaoEmail;
    public int KAKAO_CERTIFY = 0;

//    public void kakaoLogin() {
//        String TAG = "KAKAOLOGIN()";
//        UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this,(oAuthToken, error) -> {
//            if(error != null) {
//                Log.e(TAG,"로그인 실패", error);
//            } else if(oAuthToken != null) {
//                Log.i(TAG, "로그인 성공(토큰): " + oAuthToken.getAccessToken());
//                getUserInfo();
//            }
//            return null;
//        });
//    }
//
//    public void accountLogin() {
//        String TAG = "ACCOUNTLOGIN()";
//        UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this,(oAuthToken, error) -> {
//            if (error != null) {
//                Log.e(TAG, "로그인 실패", error);
//            } else if (oAuthToken != null) {
//                Log.i(TAG, "로그인 성공(토큰) : " + oAuthToken.getAccessToken());
//                getUserInfo();
//            }
//            return null;
//        });
//    }

    public void kakaoCertifySelect() {
        if(KAKAO_CERTIFY == 1) {
            Intent intent = new Intent(LoginActivity.this, RegisterSelectActivity.class);
            intent.putExtra("KAKAO_CERTIFY", KAKAO_CERTIFY); //카카오 가입 x
            startActivity(intent);
        } else {
            Toast.makeText(this,"카카오 로그인을 진행해주세요", Toast.LENGTH_SHORT);
        }
    }


    public void getUserInfo() {
        String TAG = "getUserInfo()";
        UserApiClient.getInstance().me((user, meError) -> {
            if (meError != null) {
                Log.e(TAG, "사용자 정보 요청 실패", meError);
            } else {
                System.out.println("로그인 완료");
                Log.i(TAG, user.toString());
                {
                    Log.i(TAG, "사용자 정보 요청 성공" +
                            "\n회원번호(id): " + user.getId() +
                            "\n이메일: " + user.getKakaoAccount().getEmail() +
                            "\n닉네임: " + user.getProperties().get("nickname"));
                }
                kakaoId = String.valueOf(user.getId());
                kakaoEmail = String.valueOf(user.getKakaoAccount().getEmail());
                kakaoName = String.valueOf(user.getProperties().get("nickname"));
                KAKAO_CERTIFY = 1;
                kakaoCertifySelect();
                Log.d("Certify", String.valueOf(KAKAO_CERTIFY));
//                Log.d("kakaoId", "kakaoId : " + kakaoId);
//                Log.d("kakaoName", "kakaoName: " + kakaoName);
//                Log.d("kakaoEmail", "kakaoEmail: " + kakaoEmail);

            }
            return null;
        });

    }

    public String getKeyHash() {
        try {
            PackageInfo packageInfo = getPackageManager().getPackageInfo(getPackageName(), PackageManager.GET_SIGNATURES);
            if (packageInfo == null) return null;
            for (Signature signature : packageInfo.signatures) {
                try {
                    MessageDigest messageDigest = MessageDigest.getInstance("SHA");
                    messageDigest.update(signature.toByteArray());
                    return android.util.Base64.encodeToString(messageDigest.digest(), Base64.NO_WRAP);
                } catch (NoSuchAlgorithmException e) {
                    Log.w("getKeyHash", "Unable to et MessageDigest . signature=" + signature, e);
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("getPackageInfo", "Unable to getPackageInfo", e);
        }
        return null;
    }

    class selectListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.login_signUp_tv:
                    Intent intent = new Intent(LoginActivity.this, RegisterSelectActivity.class);
                    intent.putExtra("KAKAO_CERTIFY", KAKAO_CERTIFY); //카카오 가입 x
                    startActivity(intent);
                    finish();
                    break;

                case R.id.login_login_btn:

                case R.id.login_kakao:
                    Uri uri = Uri.parse("https://kauth.kakao.com/oauth/authorize?client_id=d041b6f16d3bc4f0a3bc384015073302&redirect_uri=http://ec2-3-38-49-6.ap-northeast-2.compute.amazonaws.com:80/login/oauth2/code/kakao&response_type=code");
                    Intent intent1 = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent1);
                    break;

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

        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
            @Override
            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
                if(oAuthToken != null) {
                    Log.d("KaKao", "로그인 성공");
                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
                        @Override
                        public Unit invoke(User user, Throwable throwable) {
                          getUserInfo();
                          KAKAO_CERTIFY = 1;
                            return null;
                        }
                    });
                }
                return null;
            }
        };

        Log.d("KeyHash", getKeyHash());
        ImageView kakaoLogin = (ImageView) findViewById(R.id.login_kakao);
        kakaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                있으면 연동, 없으면 카카오톡 인터넷같이 해서 로그인하기 입니다.
//                로그인이 되거나 오류가 있으면 저기 callback 함수에서 판단하여 위에 Function2 callback 함수가 작동합니다.
                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this, callback);
                } else {
                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this, callback);
                }
//                restUri();

            }
        });
        Log.d("KAKAOCERTIFY", String.valueOf(KAKAO_CERTIFY));
    }

}
