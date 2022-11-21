package com.example.nanumeal_frontend;

import androidx.annotation.Nullable;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class RegisterRequest extends StringRequest {

    //서버 URL 연동(php 파일 연동)
    final static private String URL = "http://ftp 아이디.dothome.co.kr/Register.php";
    private Map<String, String> map;

    public RegisterRequest(String UserId, String UserPwd, String UserName, String UserNickName, String UserAge, Response.Listener<String> listener) {
        super(Method.POST, URL, listener, null);

        map = new HashMap<>();
        map.put("UserId", UserId);
        map.put("UserPwd", UserPwd);
        map.put("UserName", UserName);
        map.put("UserNickName", UserNickName);
        map.put("UserAge", UserAge);

    }

    @Nullable
    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }

}