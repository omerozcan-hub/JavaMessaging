package com.example.ClientService;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ClientServiceApplication {

	private static ClientService clientService = new ClientService();

	public ClientServiceApplication() {
	}

	public static void main(String[] args) {
		SpringApplication.run(ClientServiceApplication.class, args);
		clientService.makeOrder();
	}

}
