package com.guavapay.task.repository;

import com.guavapay.task.enums.entity.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<AdminEntity, Integer> {
}
