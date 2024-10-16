package com.example.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class InventoryService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    public void processInventory(String orderId) {

        kafkaTemplate.send("inventory-topic", "inventory enough for order " + orderId);
    }
}
