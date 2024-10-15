package com.example.OrderService;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class OrderServiceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {

		SpringApplication.run(OrderServiceApplication.class, args);

		Server server = ServerBuilder.forPort(50051)
				.addService(new OrderService()) // gRPC servisini ekle
				.build();

		System.out.println("gRPC Order Service is running on port 50051...");

		server.start();

		server.awaitTermination();
	}
}
