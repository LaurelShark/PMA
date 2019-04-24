package com.example.demo.Service;


import com.example.demo.Entity.OrderLine;
import com.example.demo.Exception.NoSuchEntityException;

import java.util.List;

public interface OrderLineService {
    OrderLine save(OrderLine orderLine);

    OrderLine findById(Integer id) throws NoSuchEntityException;

    List<OrderLine> findOrderLinesByOrderId(Integer id);

    void removeOrderLine(Integer id);
}
