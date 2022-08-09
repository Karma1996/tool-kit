package com.karma.toolkit.grpc.greeter;

import io.grpc.stub.StreamObserver;
import org.springframework.stereotype.Service;

/**
 * @author karma
 * @date 2022-08-09
 * @desc
 */
@Service
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(GreeterProto.HelloRequest request, StreamObserver<GreeterProto.HelloReply> responseObserver) {
        GreeterProto.HelloReply helloReply = GreeterProto.HelloReply.newBuilder().setMessage("hello " + request.getName()).build();
        responseObserver.onNext(helloReply);
        responseObserver.onCompleted();
    }
}
