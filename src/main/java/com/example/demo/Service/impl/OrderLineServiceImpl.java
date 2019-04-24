package com.example.demo.Service.impl;

import com.example.demo.Entity.OrderLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Repository.OrderLineRepository;
import com.example.demo.Service.OrderLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderLineServiceImpl implements OrderLineService {

    @Autowired
    private OrderLineRepository orderLineRepository;

    @Override
    public OrderLine save(OrderLine orderLine) {
        return orderLineRepository.save(orderLine);
    }


    @Override
    public OrderLine findById(Integer id) throws NoSuchEntityException {
        Optional<OrderLine> foundOrderLine = orderLineRepository.findById(id);
        return foundOrderLine.orElseThrow(() -> new NoSuchEntityException(String
                .format("OrderLine with id%s doesn't exist!", id)));
    }

    @Override
    public List<OrderLine> findOrderLinesByOrderId(Integer id){
        return (List<OrderLine>) orderLineRepository.foundOrderLinesByOrderId(id);
    }

    @Override
    public void removeOrderLine(Integer id) {
        orderLineRepository.deleteById(id);
    }
}
