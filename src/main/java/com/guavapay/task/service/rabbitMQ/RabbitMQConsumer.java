package com.guavapay.task.service.rabbitMQ;


import com.guavapay.task.dto.UserDTO;
import com.guavapay.task.service.UserService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQConsumer {

    private final UserService userService;

    public RabbitMQConsumer(UserService userService) {
        this.userService = userService;
    }

    @RabbitListener(queues = "${rabbit.queue}")
    public void recievedMessage(UserDTO userDTO) {
        userService.createUser(userDTO);
        System.out.println("Recieved Message From RabbitMQ: " + userDTO);
    }
}
