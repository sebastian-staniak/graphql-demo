package Domain;

import java.util.List;

public interface ProductsRepository {

    abstract public List<Product> all();

    abstract public List<Product> find(int id);
}