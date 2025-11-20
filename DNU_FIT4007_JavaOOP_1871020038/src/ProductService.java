package services;

import models.Product;
import exceptions.ProductNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductService {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product p) { products.add(p); }

    public Product findById(String id) throws ProductNotFoundException {
        return products.stream()
                .filter(p -> p.getProductId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ProductNotFoundException("Product Not Found: " + id));
    }

    public List<Product> searchByName(String name) {
        return products.stream()
                .filter(p -> p.getName().toLowerCase().contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }

    public void showAll() {
        products.forEach(Product::generateReport);
    }

    public List<Product> getList() { return products; }
}
