package com.example.PaymentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class PaymentService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void processPayment(String orderId) {
        boolean paymentSuccess = new Random().nextBoolean();

        if (paymentSuccess) {
            kafkaTemplate.send("payment-topic", "paymentCompleted for order " + orderId);
        } else {
            kafkaTemplate.send("payment-topic", "paymentFailed for order " + orderId);
        }
    }
}
