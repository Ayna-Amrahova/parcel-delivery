package com.guavapay.task.controller;

import com.guavapay.task.dto.BaseResponse;
import com.guavapay.task.dto.DeliveryDTO;
import com.guavapay.task.dto.LoginRequest;
import com.guavapay.task.dto.LoginResponse;
import com.guavapay.task.service.AuthService;
import com.guavapay.task.service.DeliveryService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.naming.NamingException;
import java.util.List;

@RestController
@RequestMapping("/courier")
public class CourierController {

    private final AuthService authService;
    private final DeliveryService deliveryService;

    public CourierController(AuthService authService, DeliveryService deliveryService) {
        this.authService = authService;
        this.deliveryService = deliveryService;
    }

    @ApiOperation("Endpoint for login courier")
    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest request) throws NamingException {
        return ResponseEntity.ok(BaseResponse.success(authService.login(request)));
    }

    @ApiOperation("Endpoint for getting all deliveries of courier")
    @GetMapping("/all-by-courierId")
    public ResponseEntity<BaseResponse<List<DeliveryDTO>>> getDeliveryInfoByCourierId(@RequestParam Integer courierId) {
        return ResponseEntity.ok(BaseResponse.success(deliveryService.getDeliveryByCourierId(courierId)));
    }

}
