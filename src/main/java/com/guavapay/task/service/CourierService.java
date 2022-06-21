package com.guavapay.task.service;

import com.guavapay.task.dto.CourierDTO;
import com.guavapay.task.enums.entity.CourierEntity;
import com.guavapay.task.repository.CourierRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.guavapay.task.dto.CourierDTO.fromEntity;


@Service
public class CourierService {

    private final CourierRepository courierRepository;

    public CourierService(CourierRepository courierRepository) {
        this.courierRepository = courierRepository;
    }


    public void createCourier(CourierDTO courierDTO) {
        courierRepository.save(CourierDTO.toEntity(courierDTO));
    }

    public List<CourierDTO> getAllCourier() {
        List<CourierDTO> courierDTO = new ArrayList<>();
        List<CourierEntity> entities = courierRepository.findAll();
        for (CourierEntity entity : entities) {
            courierDTO.add(fromEntity(entity));
        }

        return courierDTO;
    }


}
