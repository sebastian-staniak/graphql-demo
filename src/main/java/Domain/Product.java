package Domain;

import java.util.List;

public class Product {

    private final int id;
    private final Price price;
    private final String title;
    private final List<Screenshot> screenshots;

    public Product(int id, Price price, String title, List<Screenshot> screenshots) {
        this.id = id;
        this.price = price;
        this.title = title;
        this.screenshots = screenshots;
    }

    public int getId() {
        return id;
    }

    public Price getPrice() {
        return price;
    }

    public String getTitle() {
        return title;
    }

    public List<Screenshot> getScreenshots() {
        return screenshots;
    }
}