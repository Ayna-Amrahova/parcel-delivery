package com.guavapay.task.enums.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "parcel")
public class ParcelEntity implements Serializable {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "destination")
    private String destination;

    @Column(name = "is_cancel")
    private Integer isCancel;

    @Column(name = "order_date")
    private LocalDateTime orderDate;


    public Integer getId() {
        return id;
    }

    public ParcelEntity setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public ParcelEntity setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public String getDestination() {
        return destination;
    }

    public ParcelEntity setDestination(String destination) {
        this.destination = destination;
        return this;
    }

    public Integer getIsCancel() {
        return isCancel;
    }

    public ParcelEntity setIsCancel(Integer isCancel) {
        this.isCancel = isCancel;
        return this;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public ParcelEntity setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
        return this;
    }
}
