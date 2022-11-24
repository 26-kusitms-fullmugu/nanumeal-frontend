package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
//import com.kakao.sdk.auth.model.OAuthToken;
//import com.kakao.sdk.user.UserApiClient;
//import com.kakao.sdk.user.model.User;

import org.json.JSONException;
import org.json.JSONObject;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Calendar;
//
//import kotlin.Unit;
//import kotlin.jvm.functions.Function2;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

public class LoginActivity extends AppCompatActivity {
    public ArrayList<String> LoginValue;
    String kakaoId, name, email, loginId, password;
    String login;
    public static int KAKAO_CERTIFY = 0;


    public void kakaoCertifySelect() { //Kakao LOGIN CHECK
        if(KAKAO_CERTIFY == 1) {
            Intent intent = new Intent(LoginActivity.this, RegisterSelectActivity.class);
            intent.putExtra("KAKAO_CERTIFY", KAKAO_CERTIFY); //카카오 가입 x
            startActivity(intent);
        } else {
            Toast.makeText(getApplicationContext(),"카카오 로그인을 진행해주세요", Toast.LENGTH_SHORT);
        }
    }


    public void getUserInfo() { //user 정보 들고오기
        String TAG = "getUserInfo";
//        UserApiClient.getInstance().me((user, meError) -> {
//            if (meError != null) {
//                Log.e(TAG, "사용자 정보 요청 실패", meError);
//            } else {
//                System.out.println("로그인 완료");
//                Log.i(TAG, user.toString());
//                {
//                    Log.i(TAG, "사용자 정보 요청 성공" +
//                            "\n회원번호(id): " + user.getId() +
//                            "\n이메일: " + user.getKakaoAccount().getEmail() +
//                            "\n닉네임: " + user.getProperties().get("nickname"));
//                }
//                kakaoId = String.valueOf(user.getId());
//                email = String.valueOf(user.getKakaoAccount().getEmail());
//                name = String.valueOf(user.getProperties().get("nickname"));
//
//                KAKAO_CERTIFY = 1;
//                kakaoCertifySelect();
//                Log.d("Certify", String.valueOf(KAKAO_CERTIFY));
//                postData(kakaoId, name, email);
//
//            }
//            return null;
//        });

    }

    private void GetUserType(String loginId) { //회원 타입 받아오기(GET)

    }

    private void postLogin(String loginId, String password) { //회원 로그인(POST)
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-3-38-49-6.ap-northeast-2.compute.amazonaws.com:80/") //base url
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestApi restApi = retrofit.create(RestApi.class); //retrofit

        FormLoginModal formLoginModal = new FormLoginModal(loginId, password);
        Call<FormLoginModal> call = restApi.formLogin(formLoginModal);

        call.enqueue(new Callback<FormLoginModal>() {
            @Override
            public void onResponse(Call<FormLoginModal> call, Response<FormLoginModal> response) { //성공
                login = response.toString();
                Log.d("Login", login); //받은값 출력
            }

            @Override
            public void onFailure(Call<FormLoginModal> call, Throwable t) { //실패
                Toast.makeText(getApplicationContext(),"아이디, 비밀번호가 다릅니다!", Toast.LENGTH_SHORT);
            }
        });


    }

    private void postData(String kakaoId, String name, String email) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://ec2-3-38-49-6.ap-northeast-2.compute.amazonaws.com:80/") //base url
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        RestApi restApi = retrofit.create(RestApi.class);
        KakaoModal kakaoModal = new KakaoModal(kakaoId, name, email);
        Log.d("create_modal", "modal success");
        Call<KakaoModal> call = restApi.createPost(kakaoModal);

        call.enqueue(new Callback<KakaoModal>() {
            @Override
            public void onResponse(Call<KakaoModal> call, Response<KakaoModal> response) {
                Log.d("POST SERVER_Kakao", "success");
                KakaoModal responseFromAPI = response.body();
                String responseString = "Response Bearer: " + response.code();
                Log.d("response", responseString);
            }

            @Override
            public void onFailure(Call<KakaoModal> call, Throwable t) {
                Log.d("POST SERVER_Kakao", "fail");
            }
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
                    postLogin(loginId, password);
                    if(login.equals("login")) {
                        Intent intent1 = new Intent(LoginActivity.this, MainActivity.class);

                    }

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

        Log.d("kakao_CERTIFY_before", String.valueOf(KAKAO_CERTIFY));

//        Function2<OAuthToken, Throwable, Unit> callback = new Function2<OAuthToken, Throwable, Unit>() {
//            @Override
//            public Unit invoke(OAuthToken oAuthToken, Throwable throwable) {
//                if(oAuthToken != null) {
//                    Log.d("KaKao", "로그인 성공");
//                    UserApiClient.getInstance().me(new Function2<User, Throwable, Unit>() {
//                        @Override
//                        public Unit invoke(User user, Throwable throwable) {
//                          getUserInfo();
//                          KAKAO_CERTIFY = 1;
//                            return null;
//                        }
//                    });
//                }
//                return null;
//            }
//        };

        Log.d("KeyHash", getKeyHash());
        ImageView kakaoLogin = (ImageView) findViewById(R.id.login_kakao);
        kakaoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                있으면 연동, 없으면 카카오톡 인터넷같이 해서 로그인하기 입니다.
//                로그인이 되거나 오류가 있으면 저기 callback 함수에서 판단하여 위에 Function2 callback 함수가 작동합니다.
//                if (UserApiClient.getInstance().isKakaoTalkLoginAvailable(LoginActivity.this)) {
//                    UserApiClient.getInstance().loginWithKakaoTalk(LoginActivity.this, callback);
//                } else {
//                    UserApiClient.getInstance().loginWithKakaoAccount(LoginActivity.this, callback);
//                }

            }
        });

        Log.d("kakao_CERTIFY_after", String.valueOf(KAKAO_CERTIFY));
    }

}
