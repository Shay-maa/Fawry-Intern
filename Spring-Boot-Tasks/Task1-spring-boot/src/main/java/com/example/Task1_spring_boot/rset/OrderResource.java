package com.example.Task1_spring_boot.rset;

import com.example.Task1_spring_boot.models.Order;
import com.example.Task1_spring_boot.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("order")
public class OrderResource {
    @Autowired
    private OrderService orderServiceInFiles;

    @PostMapping
    public Order addOrder(@RequestBody Order order) throws IOException {
        Order createdOrder= orderServiceInFiles.addOrder(order);
        return createdOrder;
    }
    @GetMapping
    public List<Order> findAllOrders() throws IOException {
       List<Order> orders = orderServiceInFiles.findAllOrders();
        return orders;
    }
}
