package com.guavapay.task.repository;

import com.guavapay.task.enums.entity.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<RoleEntity, Integer> {

    public RoleEntity findByName(String theRoleName);

}
