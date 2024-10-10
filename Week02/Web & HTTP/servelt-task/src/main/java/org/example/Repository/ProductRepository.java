package org.example.Repository;

import org.example.Models.Product;
import org.example.Models.Statistics;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProductRepository {

    static List<Product> products = new ArrayList<>();

    static  {
        products.add(new Product(1, "Laptop", 999.99, "john@email.com"));
        products.add(new Product(2, "Smartphone", 499.99, "jane.smith@example.com"));
        products.add(new Product(3, "Tablet", 299.99, "alice.johnson@example.com"));
        products.add(new Product(4, "Headphones", 89.99, "bob.brown@example.com"));
        products.add(new Product(5, "Smartwatch", 199.99, "charlie.davis@example.com"));
        products.add(new Product(6, "Camera", 599.99, "john@email.com"));
        products.add(new Product(7, "Keyboard", 49.99, "frank.harris@example.com"));
        products.add(new Product(8, "Mouse", 29.99, "grace.lee@example.com"));
        products.add(new Product(9, "Monitor", 159.99, "henry.clark@example.com"));
        products.add(new Product(10, "Printer", 89.99, "john@email.com"));
    }

    public static List<Product> getProducts() {
        return products;
    }

    public Optional<Product> getProduct(int id) {
        return products.stream()
                .filter(product -> product.getId() == id)
                .findFirst();
    }

    public static List<Product> getUserProducts(String email) {
        return products.stream()
                .filter((product) -> email.equals(product.getOwnerEmail()))
                .toList()
                .reversed();
    }

    public static void addProduct(Product product) {
        products.add(product);
    }

    public static Statistics getStatistics() {
        double totalPrice = products.stream()
                .mapToDouble(Product::getPrice)
                .sum();
        return new Statistics(totalPrice, products.size());
    }

}
