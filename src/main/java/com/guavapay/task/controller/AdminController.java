package com.guavapay.task.controller;

import com.guavapay.task.dto.*;
import com.guavapay.task.service.AuthService;
import com.guavapay.task.service.CourierService;
import com.guavapay.task.service.DeliveryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AuthService authService;
    private final CourierService courierService;
    private final DeliveryService deliveryService;

    public AdminController(AuthService authService, CourierService courierService, DeliveryService deliveryService) {
        this.authService = authService;
        this.courierService = courierService;
        this.deliveryService = deliveryService;
    }


    @ApiOperation("Endpoint for login admin")
    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest request) throws NamingException {
        return ResponseEntity.ok(BaseResponse.success(authService.login(request)));
    }

    @ApiOperation("Endpoint for creating new courier")
    @PostMapping("/register-courier")
    public ResponseEntity<?> saveCourier(@RequestBody CourierDTO courierRequest) {
        courierService.createCourier(courierRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Endpoint for assign courier to delivery order")
    @PostMapping("/assign-courier")
    public ResponseEntity<?> assignCourier(@RequestBody DeliveryDTO deliveryDTO) {
        deliveryService.assignCourier(deliveryDTO);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @ApiOperation("Endpoint for track the delivery order by coordinates")
    @GetMapping("/by-coordinates")
    public ResponseEntity<BaseResponse<DeliveryDTO>> getDeliveryInfoByCoordinates(@RequestParam String coordinates) {
        return ResponseEntity.ok(BaseResponse.success(deliveryService.getDeliveryByCoordinates(coordinates)));
    }

    @ApiOperation("Endpoint for getting all couriers with statuses")
    @GetMapping("/all-courier")
    public ResponseEntity<BaseResponse<List<CourierDTO>>> getCouriers() {
        return ResponseEntity.ok(BaseResponse.success(courierService.getAllCourier()));
    }


}
