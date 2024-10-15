package com.example.OrderService;

import ecommerce.Ecommerce;
import ecommerce.OrderServiceGrpc;
import ecommerce.PaymentServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;


public class OrderService extends OrderServiceGrpc.OrderServiceImplBase{

    private final ManagedChannel paymentServiceChannel;
    private final PaymentServiceGrpc.PaymentServiceBlockingStub paymentServiceStub;

    public OrderService() {
        this.paymentServiceChannel = ManagedChannelBuilder.forAddress("localhost", 50052)
                .usePlaintext()
                .build();
        this.paymentServiceStub = PaymentServiceGrpc.newBlockingStub(paymentServiceChannel);
    }

    @Override
    public void placeOrder(Ecommerce.OrderRequest request, StreamObserver<Ecommerce.OrderResponse> responseObserver){

        Ecommerce.OrderResponse response = Ecommerce.OrderResponse.newBuilder()
                .setOrderId("12345")
                .setStatus("Order placed successfully!")
                .build();

        Ecommerce.PaymentRequest paymentRequest = Ecommerce.PaymentRequest.newBuilder()
                .setOrderId(response.getOrderId())
                .setAmount(100.50f)
                .build();

        Ecommerce.PaymentResponse paymentResponse = paymentServiceStub.processPayment(paymentRequest);

        System.out.println("Payment Confirmation: " + paymentResponse.getConfirmation());

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }

    public void shutdown() {
        paymentServiceChannel.shutdown();
    }
}
