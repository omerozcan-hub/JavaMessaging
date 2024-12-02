package org.example;

import org.zeromq.ZMQ;

public class OrderService {
    public static void main(String[] args) {

        ZMQ.Context context = ZMQ.context(1);
        ZMQ.Socket socket = context.socket(ZMQ.PUSH);
        socket.bind("tcp://*:5555");

        System.out.println("Order Service: Sending orders...");
        for (int i = 1; i <= 5; i++) {
            String order = "Order#" + i;
            socket.send(order);
            System.out.println("Sent: " + order);
        }
        socket.close();
        context.close();
    }
}