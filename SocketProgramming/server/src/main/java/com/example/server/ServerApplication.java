package com.example.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SpringBootApplication
public class ServerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ServerApplication.class, args);
		startServers();
	}

	private static void startServers() {
		new Thread(() -> startMessageServer(5000)).start();

		new Thread(() -> startFileServer(5001)).start();
	}

	private static void startMessageServer(int port) {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("Message server is listening on port " + port);

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("New client connected for messages");
				new MessageTransferHandler(socket).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void startFileServer(int port) {
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			System.out.println("File server is listening on port " + port);

			while (true) {
				Socket socket = serverSocket.accept();
				System.out.println("New client connected for file transfer");
				new FileTransferHandler(socket).start();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

}
