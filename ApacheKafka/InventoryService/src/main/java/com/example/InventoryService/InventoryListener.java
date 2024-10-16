package com.example.InventoryService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class InventoryListener {

    @Autowired
    private  InventoryService inventoryService;

    @KafkaListener(topics = "order-topic", groupId = "inventory-group")
    public void listenOrderCreated(String orderId) {
        System.out.println("Received order: " + orderId + " for stock check.");
        System.out.println("Stock is enough!");
        inventoryService.processInventory(orderId);
    }
}
