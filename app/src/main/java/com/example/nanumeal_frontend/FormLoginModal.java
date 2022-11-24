package com.example.nanumeal_frontend;

public class FormLoginModal {
    private String loginId;
    private String password;

    public FormLoginModal(String loginId, String password)
    {
        this.loginId = loginId;
        this.password = password;
    }


    public String getLoginId() {
        return loginId;
    }

    public String getPassword() {
        return password;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
