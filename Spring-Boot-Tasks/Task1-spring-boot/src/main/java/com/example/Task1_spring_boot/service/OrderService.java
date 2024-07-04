package com.example.Task1_spring_boot.service;

import com.example.Task1_spring_boot.models.Order;

import java.io.IOException;
import java.util.List;

public interface OrderService {
    public Order addOrder(Order order) throws IOException;
    public List<Order>findAllOrders() throws IOException;
}
