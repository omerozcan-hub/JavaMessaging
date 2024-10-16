package com.example.OrderService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @GetMapping("/{orderId}")
    public String createOrder(@PathVariable String orderId) {
        kafkaTemplate.send("order-topic", orderId);
        return "Order created with ID: " + orderId;
    }
}
