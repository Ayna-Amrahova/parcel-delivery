package com.guavapay.task.service.rabbitMQ;

import com.guavapay.task.dto.UserDTO;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class RabbitMQSender {

    private final AmqpTemplate rabbitTemplate;

    @Value("${rabbit.exchange}")
    private String exchange;

    @Value("${rabbit.routingkey}")
    private String routingkey;

    public RabbitMQSender(AmqpTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void send(UserDTO userDTO) {
        rabbitTemplate.convertAndSend(exchange, routingkey, userDTO);
        System.out.println("Send msg = " + userDTO);

    }
}
