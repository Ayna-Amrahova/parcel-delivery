package com.guavapay.task.dto;

import com.guavapay.task.enums.entity.ParcelEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class ParcelDTO implements Serializable {

    private Integer id;
    private Integer userId;
    private String destination;
    private Integer isCancel;
    private LocalDateTime orderDate;

    public static ParcelEntity toEntity(ParcelDTO dto) {
        return new ParcelEntity()
                .setUserId(dto.getUserId())
                .setDestination(dto.getDestination())
                .setIsCancel(dto.getIsCancel())
                .setOrderDate(LocalDateTime.now());
    }

    public static ParcelDTO fromEntity(ParcelEntity entity) {
        return new ParcelDTO()
                .setId(entity.getId())
                .setUserId(entity.getUserId())
                .setDestination(entity.getDestination())
                .setIsCancel(entity.getIsCancel())
                .setOrderDate(entity.getOrderDate());
    }

    public Integer getId() {
        return id;
    }

    public ParcelDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public ParcelDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public ParcelDTO setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public ParcelDTO setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public ParcelDTO setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }
}
