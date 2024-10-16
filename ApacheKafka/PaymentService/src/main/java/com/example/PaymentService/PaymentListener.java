package com.example.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentListener {

    @Autowired
    private PaymentService paymentService;

    @KafkaListener(topics = "order-topic", groupId = "payment-group")
    public void listenOrderCreated(String orderId) {
        System.out.println("Received order for payment: " + orderId);
        paymentService.processPayment(orderId);
    }
}

