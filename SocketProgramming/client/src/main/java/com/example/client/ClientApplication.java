package com.example.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

@SpringBootApplication
public class ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientApplication.class, args);

		String messageServerAddress = "localhost";
		int messagePort = 5000;
		String message = "Hello, this is a test message!";

		String fileServerAddress = "localhost";
		int filePort = 5001;
		String filePath = "src/main/resources/assets/a..txt";
		String fileName = "a.txt";

		MessageTransfer messageClient = new MessageTransfer(messageServerAddress, messagePort);
		messageClient.sendMessage(message);

		FileTransfer fileClient = new FileTransfer(fileServerAddress, filePort);
		fileClient.sendFile(filePath, fileName);
	}
}
