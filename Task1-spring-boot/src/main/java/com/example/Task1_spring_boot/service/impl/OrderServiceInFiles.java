package com.example.Task1_spring_boot.service.impl;

import com.example.Task1_spring_boot.models.Order;
import com.example.Task1_spring_boot.service.OrderService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.*;
import java.util.*;
import java.util.stream.Collectors;


@Service
public class OrderServiceInFiles implements OrderService {
    final static String DIRECTORY ="orders/";
    ObjectMapper mapper = new ObjectMapper();

    Path directory = (Paths.get(DIRECTORY));
    @Override
    public Order addOrder(Order order) {
        UUID id = UUID.randomUUID();
        order.setId(id);
        try {
            boolean dirExist = Files.exists(Paths.get(directory.toUri()));
            if (!dirExist) {
                Files.createDirectory(directory);
            }
            String fileName = DIRECTORY + order.getId() + ".json";
            Path filepath = Paths.get(fileName);
            Files.createFile(filepath);
            mapper.writeValue(filepath.toFile(), order);
        } catch (IOException x) {
            System.err.format("createFile error: %s%n", x);
        }
        return order;
    }

    @Override
    public List<Order> findAllOrders() {
        List<Order> orderList =new ArrayList<>();
        try{
           List<Path> filePaths= Files.walk(Paths.get(DIRECTORY)).filter(Files::isRegularFile).collect(Collectors.toList());
           for(Path path : filePaths){
               Order order = mapper.readValue(path.toFile(), Order.class);
               orderList.add(order);
           }
        }catch (IOException e){
            System.err.format("There is no files in the Directory : %s%n",e);
        }
        return orderList;
    }
}
