package com.guavapay.task.controller;

import com.guavapay.task.dto.BaseResponse;
import com.guavapay.task.dto.DeliveryDTO;
import com.guavapay.task.service.DeliveryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/delivery")
public class DeliveryController {

    private final DeliveryService deliveryService;

    public DeliveryController(DeliveryService deliveryService) {
        this.deliveryService = deliveryService;
    }

    @ApiOperation("Endpoint for creating delivery order")
    @PostMapping("/create")
    public ResponseEntity<?> createDelivery(@RequestBody DeliveryDTO deliveryDTO) {
        deliveryService.createDelivery(deliveryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Endpoint for changing status of delivery order")
    @PostMapping("/change-delivery-status")
    public ResponseEntity<?> changeDeliveryStatus(@RequestBody DeliveryDTO deliveryDTO) {
        deliveryService.changeDeliveryStatus(deliveryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Endpoint for getting delivery order of parcel")
    @GetMapping("/by-parcelId")
    public ResponseEntity<BaseResponse<DeliveryDTO>> getDeliveryInfoByParcelId(@RequestParam Integer parcelId) {
        return ResponseEntity.ok(BaseResponse.success(deliveryService.getDeliveryByParcelId(parcelId)));
    }

    @ApiOperation("Endpoint for getting all deliveries of user")
    @GetMapping("/all-by-userId")
    public ResponseEntity<BaseResponse<List<DeliveryDTO>>> getDeliveryInfoByUserId(@RequestParam Integer userId) {
        return ResponseEntity.ok(BaseResponse.success(deliveryService.getDeliveryByUserId(userId)));
    }

    @ApiOperation("Endpoint for getting all deliveries")
    @GetMapping("/all")
    public ResponseEntity<BaseResponse<List<DeliveryDTO>>> getAllDeliveryInfo() {
        return ResponseEntity.ok(BaseResponse.success(deliveryService.getAllDelivery()));
    }


}
