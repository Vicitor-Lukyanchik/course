package by.com.vicitor.course.task.fifth.filler;

import java.util.LinkedHashMap;
import java.util.Map;

import by.com.vicitor.course.task.fifth.domain.Product;

public class ProductsFiller {

    public static Map<Product, Integer> fillProducts() {
        Map<Product, Integer> products = new LinkedHashMap<>();
        products.put(new Product("chipse", 1, 4), 2);
        products.put(new Product("potato", 4, 2), 1);
        products.put(new Product("mango", 2, 5), 1);
        products.put(new Product("cucumber", 3, 3), 1);
        products.put(new Product("cofee", 5, 2), 1);
        products.put(new Product("cabbage", 2, 4), 1);
        products.put(new Product("garlic", 1, 3), 3);
        products.put(new Product("carrot", 2, 2), 1);
        return products;
    }

    public Map<Product, Integer> createProduct(String name, int volume, int cost, int productsCount) {
        validateProductData(name, volume, cost, productsCount);
        Map<Product, Integer> result = new LinkedHashMap<>();
        result.put(new Product(name, volume, cost), productsCount);
        return result;
    }
    
    private void validateProductData(String name, int volume, int cost, int productsCount) {
        if (name == null || name.equals("")) {
            throw new IllegalArgumentException("Name can not be null or empty");
        }
        if (volume == 0 || cost == 0 || productsCount == 0) {
            throw new IllegalArgumentException("Volume, cost and count of products can not be zero");
        }
    }
}
