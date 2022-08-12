package com.karma.toolkit.grpc.greeter;

import io.grpc.Status;
import io.grpc.stub.StreamObserver;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author karma
 * @date 2022-08-09
 * @desc
 */
@Service
@Slf4j
public class GreeterImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(GreeterProto.HelloRequest request, StreamObserver<GreeterProto.HelloReply> responseObserver) {
        try {
            GreeterProto.HelloReply helloReply = GreeterProto.HelloReply.newBuilder().setMessage("hello " + request.getName()).build();
            int r = 1 / 0;
            responseObserver.onNext(helloReply);
            responseObserver.onCompleted();
        } catch (Exception e) {
            log.error("error: {}", e.getMessage());
            responseObserver.onError(Status.INVALID_ARGUMENT.withDescription(e.getMessage()).withCause(e).asRuntimeException());
        }
    }
}
