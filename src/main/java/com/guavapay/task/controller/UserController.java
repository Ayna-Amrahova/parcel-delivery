package com.guavapay.task.controller;

import com.guavapay.task.dto.BaseResponse;
import com.guavapay.task.dto.UserDTO;
import com.guavapay.task.service.UserService;
import com.guavapay.task.service.rabbitMQ.RabbitMQSender;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final RabbitMQSender rabbitMQSender;
    private final UserService userService;

    public UserController(RabbitMQSender rabbitMQSender, UserService userService) {
        this.rabbitMQSender = rabbitMQSender;
        this.userService = userService;
    }

    @ApiOperation("Endpoint for creating new user")
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody UserDTO userRequest) {
        rabbitMQSender.send(userRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }


    @ApiOperation("Endpoint for get personal info of user")
    @GetMapping("/personal-info")
    public ResponseEntity<BaseResponse<UserDTO>> getPersonalInfo(@RequestParam String username) {
        return ResponseEntity.ok(BaseResponse.success(userService.findByUsername(username)));
    }


}
