package com.guavapay.task.dto;

import com.guavapay.task.enums.entity.UserEntity;

import java.io.Serializable;

public class UserDTO implements Serializable {

    private static final long serialVersionUID = 7916286765054251635L;

    private Long id;
    private String username;

    private String email;

    private String password;

    public static UserDTO fromEntity(UserEntity entity) {
        return new UserDTO()
                .setId(entity.getId())
                .setUsername(entity.getUsername())
                .setEmail(entity.getEmail())
                .setPassword(entity.getPassword());
    }

    public static UserEntity toEntity(UserDTO dto) {
        return new UserEntity()
                .setId(dto.getId())
                .setUsername(dto.getUsername())
                .setEmail(dto.getEmail())
                .setPassword(dto.getPassword());
    }

    public Long getId() {
        return id;
    }

    public UserDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
