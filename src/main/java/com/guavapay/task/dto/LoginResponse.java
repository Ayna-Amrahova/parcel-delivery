package com.guavapay.task.dto;

import java.io.Serializable;

public class LoginResponse implements Serializable {

    private static final long serialVersionUID = 6479026137739393054L;
    private String accessToken;
    private String refreshToken;


    public String getAccessToken() {
        return accessToken;
    }

    public LoginResponse setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public LoginResponse setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

}
