package Infrastructure;

import javax.servlet.annotation.WebServlet;

import graphql.schema.StaticDataFetcher;
import graphql.schema.idl.RuntimeWiring;
import graphql.schema.idl.SchemaGenerator;
import graphql.schema.idl.SchemaParser;
import graphql.schema.idl.TypeDefinitionRegistry;
import graphql.servlet.SimpleGraphQLServlet;
import graphql.schema.GraphQLSchema;
import Domain.ProductsRepository;

import java.io.*;

@WebServlet(urlPatterns = "/graphql")
public class Controller extends SimpleGraphQLServlet {
    public Controller() throws FileNotFoundException {
        super(buildSchema());
    }

    private static GraphQLSchema buildSchema() throws FileNotFoundException {
        ProductsRepository repository = new RestProductsRepository(
                new GRPCPricesRepository("localhost", 50051)
        );
        InputStream is = Controller.class.getResourceAsStream("/schema.graphqls");
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));

        SchemaParser schemaParser = new SchemaParser();
        TypeDefinitionRegistry typeDefinitionRegistry = schemaParser.parse(reader);

        RuntimeWiring runtimeWiring = RuntimeWiring.newRuntimeWiring()
                .type("Query", builder -> builder.dataFetcher("products", new ProductsDataFetcher(repository)))
                .type("Query", builder -> builder.dataFetcher("productsById", new ProductsDataFetcher(repository)))
                .build();

        SchemaGenerator schemaGenerator = new SchemaGenerator();

        return schemaGenerator.makeExecutableSchema(typeDefinitionRegistry, runtimeWiring);
    }
}