package com.example.server;

import java.io.BufferedReader;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.Socket;

public class MessageTransferHandler extends Thread {
    private Socket socket;

    public MessageTransferHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String message = reader.readLine();
            System.out.println("Received message: " + message);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

