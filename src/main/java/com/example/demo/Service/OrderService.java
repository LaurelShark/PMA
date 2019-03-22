package com.example.demo.Service;

import com.example.demo.Entity.Order;

import java.util.List;

public interface OrderService {

    Iterable<Order> findAll();
}
