package com.example.PaymentService;

import ecommerce.Ecommerce;
import ecommerce.PaymentServiceGrpc;
import io.grpc.stub.StreamObserver;

public class PaymentService extends PaymentServiceGrpc.PaymentServiceImplBase {

    @Override
    public void processPayment(Ecommerce.PaymentRequest request, StreamObserver<Ecommerce.PaymentResponse> responseObserver){
        System.out.println("Payment is taken successfully");
        String confirmationMessage = "Payment for Order " + request.getOrderId() + " has been processed.";

        Ecommerce.PaymentResponse response = Ecommerce.PaymentResponse.newBuilder()
                .setConfirmation(confirmationMessage)
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
