package com.guavapay.task.util;

import com.guavapay.task.enums.ErrorEnum;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;

import java.util.function.Function;

public enum JwtTokenType {
    ACCESS(username -> {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", "USER");
        return claims;
    }, 3600000, ErrorEnum.ACCESS_TOKEN_EXPIRED, "USER"),  // hour in millis
    REFRESH(username -> {
        Claims claims = Jwts.claims().setSubject(username);
        claims.put("roles", "REFRESH_TOKEN");
        return claims;
    }, 86400000, ErrorEnum.REFRESH_TOKEN_EXPIRED, "REFRESH_TOKEN"); // 24 hour in millis

    private final Function<String, Claims> createClaims;
    private final long validityTime;
    private ErrorEnum error;
    private String roles;

    JwtTokenType(Function<String, Claims> createClaims, long validityTime, ErrorEnum error, String roles) {
        this.createClaims = createClaims;
        this.validityTime = validityTime;
        this.error = error;
        this.roles = roles;
    }

    public Claims apply(String username) {
        return createClaims.apply(username);
    }

    public long getValidityTime() {
        return validityTime;
    }

    public ErrorEnum getError() {
        return error;
    }

    public JwtTokenType setError(ErrorEnum error) {
        this.error = error;
        return this;
    }

    public String getRoles() {
        return roles;
    }

    public JwtTokenType setRoles(String roles) {
        this.roles = roles;
        return this;
    }


}
