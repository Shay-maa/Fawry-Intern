package com.example.Task1_spring_boot.models;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

public class Order {
    private UUID id ;
    private List<Product> productList;
    private double totalAmount;

    public Order() {
    }
    public Order( List<Product> productList, double totalAmount) {
        this.productList = productList;
        this.totalAmount = totalAmount;
    }

    public void setId(UUID id) {
        this.id = id ;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public UUID getId() {
        return id;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", productList=" + productList +
                ", totalAmount=" + totalAmount +
                '}';
    }
}
