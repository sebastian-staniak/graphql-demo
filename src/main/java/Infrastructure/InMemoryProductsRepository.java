package Infrastructure;

import Domain.Product;
import Domain.Price;
import Domain.Screenshot;
import Domain.ProductsRepository;
import java.util.List;
import java.util.ArrayList;

public class InMemoryProductsRepository implements ProductsRepository {

    private final List<Product> products;

    public InMemoryProductsRepository() {
        String[] names = {
                "Witcher 1",
                "Witcher 2",
                "Witcher 3",
                "Cyberpunk 2077",
                "Gwent",
                "Hotline Miami",
                "Hotline Miami 2",
                "gears of war",
                "StarCraft",
                "StarCraft II",
        };

        products = new ArrayList<>();
        for (int i = 0; i < 10; i ++) {
            products.add(this.createProduct(i, names[i]));
        }


    }

    public List<Product> all() {
        return products;
    }

    public List<Product> find(int id) {
        return null;
    }

    private Product createProduct(int id, String name) {
        List<Screenshot> screenshots = new ArrayList<Screenshot>();
        return new Product(
            id,
            new Price(String.valueOf(id * 10), "USD"),
            name,
            screenshots
        );

    }
}