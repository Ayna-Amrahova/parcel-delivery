package com.guavapay.task.repository;

import com.guavapay.task.enums.entity.DeliveryEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DeliveryRepository extends JpaRepository<DeliveryEntity, Integer> {

    List<Optional<DeliveryEntity>> findByUserId(Integer userId);

    Optional<DeliveryEntity> findByParcelId(Integer parcelId);

    Optional<DeliveryEntity> findByCoordinates(String coordinates);

    List<Optional<DeliveryEntity>> findByCourierId(Integer courierId);
}
