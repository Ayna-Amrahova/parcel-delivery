package com.guavapay.task.controller;

import com.guavapay.task.dto.BaseResponse;
import com.guavapay.task.dto.LoginRequest;
import com.guavapay.task.dto.LoginResponse;
import com.guavapay.task.service.AuthService;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.NamingException;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @ApiOperation("Endpoint for login user")
    @PostMapping("/login")
    public ResponseEntity<BaseResponse<LoginResponse>> login(@RequestBody LoginRequest request) throws NamingException {
        return ResponseEntity.ok(BaseResponse.success(authService.login(request)));
    }

    @ApiOperation("Endpoint for logout user")
    @PostMapping("/logout")
    public ResponseEntity<?> logout() {
        authService.logout(null);
        return new ResponseEntity<>("Successfully logged out", HttpStatus.OK);
    }

}
