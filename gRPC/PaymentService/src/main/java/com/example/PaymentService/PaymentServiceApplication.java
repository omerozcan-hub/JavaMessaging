package com.example.PaymentService;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class PaymentServiceApplication {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(PaymentServiceApplication.class, args);

		Server server = ServerBuilder.forPort(50052)
				.addService(new PaymentService()) // gRPC servisini ekle
				.build();

		System.out.println("gRPC Payment Service is running on port 50052...");

		server.start();

		server.awaitTermination();
	}
}
