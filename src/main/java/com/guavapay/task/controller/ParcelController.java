package com.guavapay.task.controller;

import com.guavapay.task.dto.ParcelDTO;
import com.guavapay.task.service.ParcelService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parcel")
public class ParcelController {

    private final ParcelService parcelService;

    public ParcelController(ParcelService parcelService) {
        this.parcelService = parcelService;
    }


    @ApiOperation("Endpoint for creating parcel order")
    @PostMapping("/create-parcel-order")
    public ResponseEntity<?> createParcelOrder(@RequestBody ParcelDTO parcelDTO) {
        parcelService.createParcel(parcelDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Endpoint for changing destination of parcel order")
    @PostMapping("/change-destination-parcel-order")
    public ResponseEntity<?> changeDestinationOfParcelOrder(@RequestBody ParcelDTO parcelDTO) {
        parcelService.updateParcelDestination(parcelDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Endpoint for cancel parcel order")
    @PostMapping("/cancel-parcel-order")
    public ResponseEntity<?> cancelParcelOrder(@RequestBody ParcelDTO parcelDTO) {
        parcelService.cancelParcel(parcelDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


}
