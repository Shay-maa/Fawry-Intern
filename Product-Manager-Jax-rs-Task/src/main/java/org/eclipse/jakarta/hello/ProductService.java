package org.eclipse.jakarta.hello;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class ProductService {
    private static List<Product> products = new ArrayList<>();
    private static AtomicInteger idCounter = new AtomicInteger();
    public List<Product> findAll() {
        return products;
    }
    public Optional<Product> findById(int id){
        return products.stream().filter(p->p.getProductId()==id).findFirst();
    }
    public List<Product>findByName(String name){
        return products.stream().filter(p->p.getProductName().contains(name)).collect(Collectors.toList());
    }
    public Product addProduct(Product product) {
        product.setProductId(idCounter.incrementAndGet());
        products.add(product);
        return product;
    }
    public Optional<Product> updateProduct(int id, Product updatedProduct) {
        Optional<Product> existingProduct = findById(id);
        existingProduct.ifPresent(product -> {
            product.setProductName(updatedProduct.getProductName());
            product.setProductPrice(updatedProduct.getProductPrice());
            product.setProductDesc(updatedProduct.getProductDesc());
        });
        return existingProduct;
    }
    public boolean deleteProduct(int id) {
        return products.removeIf(p -> p.getProductId() == id);
    }

}
