package com.example.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class MessageRunner implements CommandLineRunner {

    @Autowired
    private JmsProducer producer;

    @Override
    public void run(String... args) throws Exception {
        producer.sendMessage("test-queue", "Hello from Producer!");
    }
}

