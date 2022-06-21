package com.guavapay.task.repository;

import com.guavapay.task.enums.entity.CourierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<CourierEntity, Integer> {
}
