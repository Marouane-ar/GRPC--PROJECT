package org.example.Cliente;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.example.stubs.Bank;
import org.example.stubs.BankServiceGrpc;

public class BankGrpcCliente {
    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",1234)
                .usePlaintext()
                .build();
        BankServiceGrpc.BankServiceBlockingStub blockingStub = BankServiceGrpc.newBlockingStub(managedChannel);
        Bank.ConvertCurrencyRequest request = Bank.ConvertCurrencyRequest.newBuilder()
                .setCurrencyTo("EUR")
                .setCurrencyFrom("MAD")
                .setAmmount(390)
                .build();
        Bank.ConvertCurrencyResponse convertCurrencyResponse = blockingStub.convert(request);
        System.out.println(convertCurrencyResponse);
    }
}
