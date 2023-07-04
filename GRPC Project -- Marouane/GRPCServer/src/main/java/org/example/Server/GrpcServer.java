package org.example.Server;

import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.example.Service.BankGrpcService;

import java.io.IOException;

public class GrpcServer {
    public static void main(String[] args) throws IOException, InterruptedException {
        Server server = ServerBuilder.forPort(1234)
                .addService(new BankGrpcService())
                .build();
        server.start();
        server.awaitTermination();
    }
}
