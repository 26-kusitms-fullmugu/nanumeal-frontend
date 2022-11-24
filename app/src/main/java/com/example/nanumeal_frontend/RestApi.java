package com.example.nanumeal_frontend;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface RestApi {
    @POST("/auth/login/kakao") //카카오 로그인
    Call<KakaoModal> createPost(@Body KakaoModal kakaoModal);

    @POST("/auth/verify/login-id") //로그인 아이디 중복 확인
    Call<FormLoginModal> certifyID(@Body FormLoginModal idModal);

    @POST("/auth/verify/email") //로그인 이메일 중복 확인
    Call<LoginModal> certifyEmail(@Body LoginModal emailModal);

    @POST("/auth/verify/nickname") //닉네임 중복 확인
    Call<LoginModal> certifyNickname(@Body LoginModal nickNameModal);

    @POST("/auth/login") //그냥 로그인
    Call<FormLoginModal> formLogin(@Body FormLoginModal formLoginModal);




}
