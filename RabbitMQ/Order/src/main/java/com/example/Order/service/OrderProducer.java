package com.example.Order.service;

import com.example.Order.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {
    private Logger LOGGER = LoggerFactory.getLogger(OrderProducer.class);

    @Value("${rabbitmq.exchange.name}")
    private String exchange;

    @Value("${rabbitmq.binding.order.routing.key}")
    private String orderRoutingKey;

    @Value("${rabbitmq.binding.email.routing.key}")
    private String emailRoutingKey;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public OrderProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendMessage(OrderEvent orderEvent) {
        LOGGER.info(String.format("Order event sent to RabbitMQ => %s", orderEvent.toString()));

        // Burayı dinleyen stock servis olacak
        rabbitTemplate.convertAndSend(exchange, orderRoutingKey, orderEvent);

        // Burayı dinleyen email servis olacak
        rabbitTemplate.convertAndSend(exchange, emailRoutingKey, orderEvent);
    }
}
