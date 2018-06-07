package Infrastructure;

import Domain.Price;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

public class GRPCPricesRepository {

    private Infrastructure.PricingServiceGrpc.PricingServiceBlockingStub stub;

    public GRPCPricesRepository(String host, int port) {
        ManagedChannel channel = ManagedChannelBuilder.forAddress(host, port)
                .usePlaintext(true)
                .build();

        this.stub = Infrastructure.PricingServiceGrpc.newBlockingStub(channel);
    }


    public Price fetchPrice(int productId, String currency) {

        Infrastructure.Prices.Price response = stub.calculate(
                Infrastructure.Prices.PriceRequest.newBuilder()
                    .setCurrency(currency)
                    .setProductId(productId)
                    .build());

        return new Price(
            String.valueOf(response.getAmount()),
            currency
        );
    }
}
