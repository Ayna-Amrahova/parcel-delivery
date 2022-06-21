package com.guavapay.task.enums.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "delivery")
public class DeliveryEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "parcel_id")
    private Integer parcelId;

    @Column(name = "delivery_status_id")
    private Integer deliveryStatusId;

    @Column(name = "courier_id")
    private Integer courierId;

    @Column(name = "coordinates")
    private String coordinates;

    @Column(name = "status_date")
    private LocalDateTime statusDate;


    public Integer getId() {
        return id;
    }

    public DeliveryEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public DeliveryEntity setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getParcelId() {
        return parcelId;
    }

    public DeliveryEntity setParcelId(Integer parcelId) {
        this.parcelId = parcelId;
        return this;
    }

    public Integer getDeliveryStatusId() {
        return deliveryStatusId;
    }

    public DeliveryEntity setDeliveryStatusId(Integer deliveryStatusId) {
        this.deliveryStatusId = deliveryStatusId;
        return this;
    }

    public Integer getCourierId() {
        return courierId;
    }

    public DeliveryEntity setCourierId(Integer courierId) {
        this.courierId = courierId;
        return this;
    }

    public String getCoordinates() {
        return coordinates;
    }

    public DeliveryEntity setCoordinates(String coordinates) {
        this.coordinates = coordinates;
        return this;
    }

    public LocalDateTime getStatusDate() {
        return statusDate;
    }

    public DeliveryEntity setStatusDate(LocalDateTime statusDate) {
        this.statusDate = statusDate;
        return this;
    }
}
