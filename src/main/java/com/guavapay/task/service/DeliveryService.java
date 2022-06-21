package com.guavapay.task.service;

import com.guavapay.task.dto.DeliveryDTO;
import com.guavapay.task.enums.entity.DeliveryEntity;
import com.guavapay.task.enums.ErrorEnum;
import com.guavapay.task.exception.RestException;
import com.guavapay.task.repository.DeliveryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.guavapay.task.dto.DeliveryDTO.fromEntity;
import static com.guavapay.task.dto.DeliveryDTO.toEntity;


@Service
public class DeliveryService {

    private final DeliveryRepository deliveryRepository;
    private final ParcelService parcelService;

    public DeliveryService(DeliveryRepository deliveryRepository, ParcelService parcelService) {
        this.deliveryRepository = deliveryRepository;
        this.parcelService = parcelService;
    }


    public DeliveryDTO createDelivery(DeliveryDTO deliveryDTO) {
        return fromEntity(deliveryRepository.save(toEntity(deliveryDTO)));
    }

    public DeliveryDTO getDeliveryByParcelId(Integer parcelId) {
        return DeliveryDTO.fromEntity(
                deliveryRepository.findByParcelId(parcelId).orElseThrow(() -> RestException.of(ErrorEnum.DELIVERY_NOT_FOUND)));
    }

    public List<DeliveryDTO> getDeliveryByUserId(Integer userId) {
        List<DeliveryDTO> deliveryDTO = new ArrayList<>();
        List<Optional<DeliveryEntity>> byUserId = deliveryRepository.findByUserId(userId);
        for (Optional<DeliveryEntity> entity : byUserId) {
            deliveryDTO.add(fromEntity(entity.orElseThrow(() -> RestException.of(ErrorEnum.DELIVERY_NOT_FOUND))));
        }

        return deliveryDTO;
    }

    public List<DeliveryDTO> getAllDelivery() {
        List<DeliveryDTO> deliveryDTO = new ArrayList<>();
        List<DeliveryEntity> entities = deliveryRepository.findAll();
        for (DeliveryEntity entity : entities) {
            deliveryDTO.add(fromEntity(entity));
        }

        return deliveryDTO;
    }

    public DeliveryEntity getDeliveryEntityById(Integer id) {
        Optional<DeliveryEntity> deliveryEntityById = deliveryRepository.findById(id);
        return deliveryEntityById.orElseThrow(() -> RestException.of(ErrorEnum.DELIVERY_NOT_FOUND));
    }

    public DeliveryDTO changeDeliveryStatus(DeliveryDTO deliveryDTO) {
        DeliveryEntity deliveryEntity = toEntity(getDeliveryByParcelId(deliveryDTO.getParcelId()));
        deliveryEntity.setDeliveryStatusId(deliveryDTO.getDeliveryStatusId());

        return fromEntity(deliveryRepository.save(deliveryEntity));
    }


    public DeliveryDTO assignCourier(DeliveryDTO deliveryDTO) {
        DeliveryEntity deliveryEntity = toEntity(getDeliveryByParcelId(deliveryDTO.getParcelId()));
        deliveryEntity.setCourierId(deliveryDTO.getCourierId());

        return fromEntity(deliveryRepository.save(deliveryEntity));
    }

    public DeliveryDTO getDeliveryByCoordinates(String coordinates) {
        return DeliveryDTO.fromEntity(
                deliveryRepository.findByCoordinates(coordinates).orElseThrow(() -> RestException.of(ErrorEnum.DELIVERY_NOT_FOUND)));
    }

    public List<DeliveryDTO> getDeliveryByCourierId(Integer courierId) {
        List<DeliveryDTO> deliveryDTO = new ArrayList<>();
        List<Optional<DeliveryEntity>> byCourierId = deliveryRepository.findByCourierId(courierId);
        for (Optional<DeliveryEntity> entity : byCourierId) {
            deliveryDTO.add(fromEntity(entity.orElseThrow(() -> RestException.of(ErrorEnum.DELIVERY_NOT_FOUND))));
        }

        return deliveryDTO;
    }

}
