package com.guavapay.task.enums.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "courier")
public class CourierEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "status")
    private String status;

    public Long getId() {
        return id;
    }

    public CourierEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public CourierEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public CourierEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public CourierEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public CourierEntity setStatus(String status) {
        this.status = status;
        return this;
    }
}
