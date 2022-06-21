package com.guavapay.task.enums.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "USER_TOKENS")
public class UserTokensEntity implements Serializable {

    private static final long serialVersionUID = 7916286765054251635L;

    @Id
    @Column(name = "USER_TOKEN_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "USERNAME")
    private String username;

    @Column(name = "ACCESS_TOKEN")
    private String accessToken;

    @Column(name = "ACCESS_TOKEN_EXPIRE_DATE")
    private LocalDateTime accessTokenExpireDate;

    @Column(name = "REFRESH_TOKEN")
    private String refreshToken;

    @Column(name = "REFRESH_TOKEN_EXPIRE_DATE")
    private LocalDateTime refreshTokenExpireDate;

    public Long getId() {
        return id;
    }

    public UserTokensEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserTokensEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public UserTokensEntity setAccessToken(String accessToken) {
        this.accessToken = accessToken;
        return this;
    }

    public LocalDateTime getAccessTokenExpireDate() {
        return accessTokenExpireDate;
    }

    public UserTokensEntity setAccessTokenExpireDate(LocalDateTime accessTokenExpireDate) {
        this.accessTokenExpireDate = accessTokenExpireDate;
        return this;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public UserTokensEntity setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
        return this;
    }

    public LocalDateTime getRefreshTokenExpireDate() {
        return refreshTokenExpireDate;
    }

    public UserTokensEntity setRefreshTokenExpireDate(LocalDateTime refreshTokenExpireDate) {
        this.refreshTokenExpireDate = refreshTokenExpireDate;
        return this;
    }

    @Override
    public String toString() {
        return "UserTokensEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", accessToken='" + accessToken + '\'' +
                ", accessTokenExpireDate=" + accessTokenExpireDate +
                ", refreshToken='" + refreshToken + '\'' +
                ", refreshTokenExpireDate=" + refreshTokenExpireDate +
                '}';
    }
}
