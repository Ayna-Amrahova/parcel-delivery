package com.guavapay.task.dto;

import com.guavapay.task.enums.entity.DeliveryEntity;

import java.io.Serializable;
import java.time.LocalDateTime;

public class DeliveryDTO implements Serializable {

    private Integer id;
    private Integer userId;
    private Integer parcelId;
    private Integer deliveryStatusId;
    private Integer courierId;
    private String coordinates;
    private LocalDateTime statusDate;


    public static DeliveryEntity toEntity(DeliveryDTO dto) {
        return new DeliveryEntity()
                .setUserId(dto.getUserId())
                .setParcelId(dto.getParcelId())
                .setDeliveryStatusId(dto.getDeliveryStatusId())
                .setCourierId(dto.getCourierId())
                .setCoordinates(dto.getCoordinates())
                .setStatusDate(LocalDateTime.now());
    }


    public static DeliveryDTO fromEntity(DeliveryEntity entity) {
        return new DeliveryDTO()
                .setId(entity.getId())
                .setUserId(entity.getUserId())
                .setParcelId(entity.getParcelId())
                .setDeliveryStatusId(entity.getDeliveryStatusId())
                .setCourierId(entity.getCourierId())
                .setCoordinates(entity.getCoordinates())
                .setStatusDate(entity.getStatusDate());
    }

    public Integer getId() {
        return id;
    }

    public DeliveryDTO setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public DeliveryDTO setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getParcelId() {
        return parcelId;
    }

    public DeliveryDTO setParcelId(Integer parcelId) {
        this.parcelId = parcelId;
        return this;
    }

    public Integer getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public DeliveryDTO setDeliveryStatusId(Integer deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
        return this;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public DeliveryDTO setCourierId(Integer courierId) {
        this.courierId = courierId;
        return this;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public DeliveryDTO setCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public DeliveryDTO setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
        return this;
    }
}
