package com.example.demo.Service;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.OrderLine;
import com.example.demo.Exception.NoSuchEntityException;

import java.util.List;


public interface OrderService {

    Iterable<Order> findAll();

    Order save(Order order);

    Order findOrderById(Integer id) throws NoSuchEntityException;

    Order updateOrder(OrderDto orderDto, Integer id) throws Exception;

    void removeOrder(Integer id);
}
