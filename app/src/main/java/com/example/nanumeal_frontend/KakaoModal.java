package com.example.nanumeal_frontend;

public class KakaoModal {
    private String kakaoId;
    private String name;
    private String email;
    private String requestCode;

    public KakaoModal(String kakaoId, String name, String email) {
        this.kakaoId = kakaoId;
        this.name = name;
        this.email = email;
    }

    public void setKakaoId(String kakaoId) {
        this.kakaoId = kakaoId;
    }

    public String getRequestCode() {
        return getRequestCode();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getKakaoId() {
        return kakaoId;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }


}
