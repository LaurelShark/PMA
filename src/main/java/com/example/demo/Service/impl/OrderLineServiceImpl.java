package com.example.demo.Service.impl;

import com.example.demo.Entity.OrderLine;
import com.example.demo.Repository.OrderLineRepository;
import com.example.demo.Service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderLine save(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }
}
