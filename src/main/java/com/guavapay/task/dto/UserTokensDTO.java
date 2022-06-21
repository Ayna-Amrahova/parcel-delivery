package com.guavapay.task.dto;

import com.guavapay.task.enums.entity.UserTokensEntity;

import java.time.LocalDateTime;

public class UserTokensDTO {

    private Long id;
    private String username;
    private String accessToken;
    private LocalDateTime accessTokenExpireDate;
    private String refreshToken;
    private LocalDateTime refreshTokenExpireDate;

    public static UserTokensDTO fromEntity(UserTokensEntity entity) {
        return new UserTokensDTO()
                .setId(entity.getId())
                .setUsername(entity.getUsername())
                .setAccessToken(entity.getAccessToken())
                .setAccessTokenExpireDate(entity.getAccessTokenExpireDate())
                .setRefreshToken(entity.getRefreshToken())
                .setRefreshTokenExpireDate(entity.getRefreshTokenExpireDate());
    }

    public static UserTokensEntity toEntity(UserTokensDTO dto) {
        return new UserTokensEntity()
                .setId(dto.getId())
                .setUsername(dto.getUsername())
                .setAccessToken(dto.getAccessToken())
                .setAccessTokenExpireDate(dto.getAccessTokenExpireDate())
                .setRefreshToken(dto.getRefreshToken())
                .setRefreshTokenExpireDate(dto.getRefreshTokenExpireDate());
    }

    public Long getId() {
        return id;
    }

    public UserTokensDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserTokensDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public UserTokensDTO setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public LocalDateTime getAccessTokenExpireDate() {
        return accessTokenExpireDate;
    }

    public UserTokensDTO setAccessTokenExpireDate(LocalDateTime accessTokenExpireDate) {
        this.accessTokenExpireDate = accessTokenExpireDate;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserTokensDTO setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public LocalDateTime getRefreshTokenExpireDate() {
        return refreshTokenExpireDate;
    }

    public UserTokensDTO setRefreshTokenExpireDate(LocalDateTime refreshTokenExpireDate) {
        this.refreshTokenExpireDate = refreshTokenExpireDate;
        return this;
    }

    @Override
    public String toString() {
        return "UserTokensDTO{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpireDate=" + accessTokenExpireDate +
                ", refreshToken='" + refreshToken + '\'' +
                ", refreshTokenExpireDate=" + refreshTokenExpireDate +
                '}';
    }
}
