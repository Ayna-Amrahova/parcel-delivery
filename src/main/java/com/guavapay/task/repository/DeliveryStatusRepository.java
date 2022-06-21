package com.guavapay.task.repository;

import com.guavapay.task.enums.entity.DeliveryStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryStatusRepository extends JpaRepository<DeliveryStatusEntity, Integer> {
}
