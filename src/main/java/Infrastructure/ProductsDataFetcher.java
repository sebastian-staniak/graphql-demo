package Infrastructure;

import Domain.ProductsRepository;
import graphql.schema.DataFetcher;
import graphql.schema.DataFetchingEnvironment;

import java.util.ArrayList;

public class ProductsDataFetcher implements DataFetcher {
    private final ProductsRepository repository;

    public ProductsDataFetcher(ProductsRepository repository) {
        this.repository = repository;
    }

    public Object get(DataFetchingEnvironment environment) {
        try {
            int id = environment.getArgument("id");

            return repository.find(id);
        } catch (Exception e) {
            return repository.all();
        }

    }
}
