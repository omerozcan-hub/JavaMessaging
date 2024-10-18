package com.example.client;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class FileTransfer {

    private String serverAddress;
    private int port;

    public FileTransfer(String serverAddress, int port) {
        this.serverAddress = serverAddress;
        this.port = port;
    }

    public void sendFile(String filePath, String fileName) {
        try (Socket socket = new Socket(serverAddress, port);
             OutputStream outputStream = socket.getOutputStream();
             PrintWriter writer = new PrintWriter(outputStream, true);
             FileInputStream fileInputStream = new FileInputStream(filePath)) {

            writer.println(fileName);

            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fileInputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            System.out.println("File sent: " + fileName);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
