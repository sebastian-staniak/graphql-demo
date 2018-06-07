package Infrastructure;

import Domain.Price;
import Domain.Product;
import Domain.ProductsRepository;
import Domain.Screenshot;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import java.util.stream.Collectors;

public class RestProductsRepository implements ProductsRepository {

    private GRPCPricesRepository pricesRepository;

    public RestProductsRepository(GRPCPricesRepository pricesRepository) {
        this.pricesRepository = pricesRepository;
    }

    @Override
    public List<Product> all() {
        try {
            return hydrate(fetchFromApi());

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<Product>();
    }

    @Override
    public List<Product> find(int id) {
        try {
            return hydrate(fetchFromApi(id));

        } catch (IOException e) {
            e.printStackTrace();
        }

        return new ArrayList<Product>();
    }

    private JsonElement fetchFromApi() throws IOException {
        return execute(new URL("https://api.gog.com/v1/games"));
    }

    private JsonElement fetchFromApi(int id) throws IOException {
        return execute(new URL("https://api.gog.com/v1/games?productIds=" + id));
    }

    private JsonElement execute(URL url) throws IOException {
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        String data = br.lines().collect(Collectors.joining());

        JsonParser jsonParser = new JsonParser();
        JsonElement jsonElement = jsonParser.parse(data);

        conn.disconnect();

        return jsonElement;
    }

    private List<Product> hydrate(JsonElement json) {
        List products = new ArrayList<Product>();

        JsonArray x = json
                .getAsJsonObject()
                .get("_embedded")
                .getAsJsonObject()
                .get("items")
                .getAsJsonArray();

        x.forEach((el) -> {
            JsonObject jsonProduct = el
                    .getAsJsonObject()
                    .get("_embedded")
                    .getAsJsonObject()
                    .get("product")
                    .getAsJsonObject();
            List<Screenshot> screenshots = new ArrayList<Screenshot>();

            products.add(
                new Product(
                    jsonProduct.get("id").getAsInt(),
                    this.pricesRepository.fetchPrice(jsonProduct.get("id").getAsInt(), "USD"),
                    jsonProduct.get("title").getAsString(),
                    screenshots
                )
            );
        });

        return  products;
    }
}
