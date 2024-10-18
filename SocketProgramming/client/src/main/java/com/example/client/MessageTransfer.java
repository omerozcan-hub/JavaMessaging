package com.example.client;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class MessageTransfer {

    private String serverAddress;
    private int messagePort;

    public MessageTransfer(String serverAddress, int messagePort) {
        this.serverAddress = serverAddress;
        this.messagePort = messagePort;
    }

    public void sendMessage(String message) {
        try (Socket socket = new Socket(serverAddress, messagePort);
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream, true)) {

            writer.println(message);
            System.out.println("Message sent: " + message);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}