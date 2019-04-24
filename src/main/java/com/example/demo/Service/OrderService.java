package com.example.demo.Service;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;
import com.example.demo.Exception.NoSuchEntityException;


public interface OrderService {

    Iterable<Order> findAll();

    Order save(Order order);

    Order findOrderById(Integer id) throws NoSuchEntityException;

    Order updateOrder(OrderDto orderDto, Integer id) throws Exception;

    Iterable<Order> getApprovedOrders(String status);

    void approveOrder(Integer id) throws NoSuchEntityException;

    void removeOrder(Integer id);
}
