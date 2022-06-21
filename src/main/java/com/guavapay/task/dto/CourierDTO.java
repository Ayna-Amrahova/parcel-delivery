package com.guavapay.task.dto;

import com.guavapay.task.enums.entity.CourierEntity;

import java.io.Serializable;

public class CourierDTO implements Serializable {

    private static final long serialVersionUID = 7916286765054251635L;

    private Long id;
    private String username;

    private String email;

    private String password;

    public static CourierDTO fromEntity(CourierEntity entity) {
        return new CourierDTO()
                .setId(entity.getId())
                .setUsername(entity.getUsername())
                .setEmail(entity.getEmail())
                .setPassword(entity.getPassword());
    }

    public static CourierEntity toEntity(CourierDTO dto) {
        return new CourierEntity()
                .setId(dto.getId())
                .setUsername(dto.getUsername())
                .setEmail(dto.getEmail())
                .setPassword(dto.getPassword());
    }

    public Long getId() {
        return id;
    }

    public CourierDTO setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CourierDTO setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CourierDTO setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CourierDTO setPassword(String password) {
        this.password = password;
        return this;
    }
}
