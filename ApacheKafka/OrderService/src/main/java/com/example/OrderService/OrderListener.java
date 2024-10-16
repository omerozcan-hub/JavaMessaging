package com.example.OrderService;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class OrderListener {

    @KafkaListener(topics = "payment-topic", groupId = "order-group")
    public void listenPaymentEvents(String paymentMessage) {
        System.out.println("Received payment update: " + paymentMessage);
    }

    @KafkaListener(topics = "inventory-topic", groupId = "order-group")
    public void listenInventoryEvents(String inventoryMessage) {
        System.out.println("Received payment update: " + inventoryMessage);
    }
}

