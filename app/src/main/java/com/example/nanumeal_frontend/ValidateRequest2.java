package com.example.nanumeal_frontend;

import com.android.volley.AuthFailureError;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class ValidateRequest2 extends StringRequest {
    //서버 url 설정(php파일 연동)
    final static  private String URL="http://아이디.dothome.co.kr/UserValidate.php";
    private Map<String, String> map;

    public ValidateRequest2(String UserNickName, Response.Listener<String> listener){
        super(Method.POST, URL, listener,null);

        map = new HashMap<>();
        map.put("UserId", UserNickName);
    }


    @Override
    protected Map<String, String> getParams() throws AuthFailureError {
        return map;
    }
}
