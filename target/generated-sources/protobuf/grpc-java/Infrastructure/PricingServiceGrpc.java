package Infrastructure;

import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.12.0)",
    comments = "Source: prices.proto")
public final class PricingServiceGrpc {

  private PricingServiceGrpc() {}

  public static final String SERVICE_NAME = "Infrastructure.PricingService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  @java.lang.Deprecated // Use {@link #getCalculateMethod()} instead. 
  public static final io.grpc.MethodDescriptor<Infrastructure.Prices.PriceRequest,
      Infrastructure.Prices.Price> METHOD_CALCULATE = getCalculateMethodHelper();

  private static volatile io.grpc.MethodDescriptor<Infrastructure.Prices.PriceRequest,
      Infrastructure.Prices.Price> getCalculateMethod;

  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static io.grpc.MethodDescriptor<Infrastructure.Prices.PriceRequest,
      Infrastructure.Prices.Price> getCalculateMethod() {
    return getCalculateMethodHelper();
  }

  private static io.grpc.MethodDescriptor<Infrastructure.Prices.PriceRequest,
      Infrastructure.Prices.Price> getCalculateMethodHelper() {
    io.grpc.MethodDescriptor<Infrastructure.Prices.PriceRequest, Infrastructure.Prices.Price> getCalculateMethod;
    if ((getCalculateMethod = PricingServiceGrpc.getCalculateMethod) == null) {
      synchronized (PricingServiceGrpc.class) {
        if ((getCalculateMethod = PricingServiceGrpc.getCalculateMethod) == null) {
          PricingServiceGrpc.getCalculateMethod = getCalculateMethod = 
              io.grpc.MethodDescriptor.<Infrastructure.Prices.PriceRequest, Infrastructure.Prices.Price>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(
                  "Infrastructure.PricingService", "calculate"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Infrastructure.Prices.PriceRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  Infrastructure.Prices.Price.getDefaultInstance()))
                  .setSchemaDescriptor(new PricingServiceMethodDescriptorSupplier("calculate"))
                  .build();
          }
        }
     }
     return getCalculateMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static PricingServiceStub newStub(io.grpc.Channel channel) {
    return new PricingServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static PricingServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new PricingServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static PricingServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new PricingServiceFutureStub(channel);
  }

  /**
   */
  public static abstract class PricingServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public void calculate(Infrastructure.Prices.PriceRequest request,
        io.grpc.stub.StreamObserver<Infrastructure.Prices.Price> responseObserver) {
      asyncUnimplementedUnaryCall(getCalculateMethodHelper(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getCalculateMethodHelper(),
            asyncUnaryCall(
              new MethodHandlers<
                Infrastructure.Prices.PriceRequest,
                Infrastructure.Prices.Price>(
                  this, METHODID_CALCULATE)))
          .build();
    }
  }

  /**
   */
  public static final class PricingServiceStub extends io.grpc.stub.AbstractStub<PricingServiceStub> {
    private PricingServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PricingServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PricingServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PricingServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public void calculate(Infrastructure.Prices.PriceRequest request,
        io.grpc.stub.StreamObserver<Infrastructure.Prices.Price> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(getCalculateMethodHelper(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class PricingServiceBlockingStub extends io.grpc.stub.AbstractStub<PricingServiceBlockingStub> {
    private PricingServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PricingServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PricingServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PricingServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public Infrastructure.Prices.Price calculate(Infrastructure.Prices.PriceRequest request) {
      return blockingUnaryCall(
          getChannel(), getCalculateMethodHelper(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class PricingServiceFutureStub extends io.grpc.stub.AbstractStub<PricingServiceFutureStub> {
    private PricingServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private PricingServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected PricingServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new PricingServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     * Define a RPC operation
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<Infrastructure.Prices.Price> calculate(
        Infrastructure.Prices.PriceRequest request) {
      return futureUnaryCall(
          getChannel().newCall(getCalculateMethodHelper(), getCallOptions()), request);
    }
  }

  private static final int METHODID_CALCULATE = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final PricingServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(PricingServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_CALCULATE:
          serviceImpl.calculate((Infrastructure.Prices.PriceRequest) request,
              (io.grpc.stub.StreamObserver<Infrastructure.Prices.Price>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class PricingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    PricingServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return Infrastructure.Prices.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("PricingService");
    }
  }

  private static final class PricingServiceFileDescriptorSupplier
      extends PricingServiceBaseDescriptorSupplier {
    PricingServiceFileDescriptorSupplier() {}
  }

  private static final class PricingServiceMethodDescriptorSupplier
      extends PricingServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    PricingServiceMethodDescriptorSupplier(String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (PricingServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new PricingServiceFileDescriptorSupplier())
              .addMethod(getCalculateMethodHelper())
              .build();
        }
      }
    }
    return result;
  }
}
