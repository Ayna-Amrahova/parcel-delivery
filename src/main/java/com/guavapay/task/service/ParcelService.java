package com.guavapay.task.service;

import com.guavapay.task.dto.ParcelDTO;
import com.guavapay.task.enums.entity.ParcelEntity;
import com.guavapay.task.enums.ErrorEnum;
import com.guavapay.task.exception.RestException;
import com.guavapay.task.repository.ParcelRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

import static com.guavapay.task.dto.ParcelDTO.fromEntity;
import static com.guavapay.task.dto.ParcelDTO.toEntity;

@Service
public class ParcelService {

    private final ParcelRepository parcelRepository;

    public ParcelService(ParcelRepository parcelRepository) {
        this.parcelRepository = parcelRepository;
    }


    public ParcelDTO createParcel(ParcelDTO parcelDTO) {
        return fromEntity(parcelRepository.save(toEntity(parcelDTO)));
    }


    public ParcelDTO updateParcelDestination(ParcelDTO parcelDTO) {
        ParcelEntity parcelEntity = getParcelEntityById(parcelDTO.getId());
        LocalDateTime toDate = LocalDateTime.now();
        LocalDateTime fromDate = toDate.minusDays(3);
        if (parcelEntity.getOrderDate().isAfter(fromDate))
        parcelEntity.setDestination(parcelDTO.getDestination());

        return fromEntity(parcelRepository.save(parcelEntity));
    }


    public ParcelDTO cancelParcel(ParcelDTO parcelDTO) {
        ParcelEntity parcelEntity = getParcelEntityById(parcelDTO.getId());
        LocalDateTime toDate = LocalDateTime.now();
        LocalDateTime fromDate = toDate.minusDays(3);
        if (parcelEntity.getOrderDate().isAfter(fromDate))
        parcelEntity.setIsCancel(1);

        return fromEntity(parcelRepository.save(parcelEntity));
    }

    public ParcelDTO getParcelById(Integer id) {
        Optional<ParcelEntity> parcelEntityById = parcelRepository.findById(id);
        return ParcelDTO.fromEntity(parcelEntityById.orElseThrow(() -> RestException.of(ErrorEnum.PARCEL_NOT_FOUND)));
    }

    public ParcelEntity getParcelEntityById(Integer id) {
        Optional<ParcelEntity> parcelEntityById = parcelRepository.findById(id);
        return parcelEntityById.orElseThrow(() -> RestException.of(ErrorEnum.PARCEL_NOT_FOUND));
    }


}
