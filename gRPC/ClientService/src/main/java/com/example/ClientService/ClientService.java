package com.example.ClientService;

import ecommerce.Ecommerce;
import ecommerce.OrderServiceGrpc;
import ecommerce.PaymentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class ClientService {

    private final ManagedChannel orderServiceChannel;
    private final OrderServiceGrpc.OrderServiceBlockingStub orderServiceStub;

    public ClientService() {
        this.orderServiceChannel = ManagedChannelBuilder.forAddress("localhost", 50051)
                .usePlaintext()
                .build();
        this.orderServiceStub = OrderServiceGrpc.newBlockingStub(orderServiceChannel);
    }

    public void makeOrder(){
        Ecommerce.OrderRequest orderRequest = Ecommerce.OrderRequest.newBuilder()
                .setProductId("prod-12345")
                .setQuantity(2)
                .build();

        Ecommerce.OrderResponse orderResponse = orderServiceStub.placeOrder(orderRequest);

        System.out.println("Client Confirmation: " + orderResponse.getStatus());

        System.out.println("Order is taken successfully!");
    }

}
