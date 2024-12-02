package org.example;

import org.zeromq.ZMQ;

public class InventoryService {
    public static void main(String[] args) {

        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket receiver = context.socket(ZMQ.PULL);
        receiver.connect("tcp://localhost:5555");

        ZMQ.Socket sender = context.socket(ZMQ.PUSH);
        sender.bind("tcp://*:5556");

        System.out.println("Inventory Service: Processing orders...");
        while (true) {
            String order = receiver.recvStr();
            System.out.println("Received: " + order);
            String response = order + " is processed and in stock.";
            sender.send(response);
            System.out.println("Sent: " + response);
        }
    }
}