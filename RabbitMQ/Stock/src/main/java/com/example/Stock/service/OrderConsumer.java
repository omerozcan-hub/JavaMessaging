package com.example.Stock.service;

import com.example.Stock.dto.OrderEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class OrderConsumer {

    private Logger LOGGER = LoggerFactory.getLogger(OrderConsumer.class);

    @RabbitListener(queues = "${rabbitmq.queue.order.name}")
    public void consume(OrderEvent event){
        LOGGER.info(String.format("Order event received => %s", event.toString()));

        // Burada DB ye kayıt işlemi olabilir, ben sadece log da göstereceğim.
    }
}