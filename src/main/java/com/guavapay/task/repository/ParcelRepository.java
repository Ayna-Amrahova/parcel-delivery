package com.guavapay.task.repository;

import com.guavapay.task.enums.entity.ParcelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParcelRepository extends JpaRepository<ParcelEntity, Integer> {
}
