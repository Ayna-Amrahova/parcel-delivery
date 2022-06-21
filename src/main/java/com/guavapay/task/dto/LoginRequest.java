package com.guavapay.task.dto;

import java.io.Serializable;

public class LoginRequest implements Serializable {

    private static final long serialVersionUID = -7754901152689483254L;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public LoginRequest setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public LoginRequest setPassword(String password) {
        this.password = password;
        return this;
    }
}
