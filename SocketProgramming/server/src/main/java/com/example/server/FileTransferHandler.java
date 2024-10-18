package com.example.server;

import java.io.*;
import java.net.Socket;

public class FileTransferHandler extends Thread {
    private Socket socket;

    public FileTransferHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try (InputStream inputStream = socket.getInputStream();
             PrintWriter writer = new PrintWriter(socket.getOutputStream(), true)) {

            byte[] buffer = new byte[4096];
            int bytesRead;

            String fileName = new BufferedReader(new InputStreamReader(inputStream)).readLine();
            System.out.println("Receiving file: " + fileName);

            try (FileOutputStream fileOutputStream = new FileOutputStream(fileName)) {
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }
            }

            System.out.println("File received: " + fileName);

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
