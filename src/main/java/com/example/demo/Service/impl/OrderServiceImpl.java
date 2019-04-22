package com.example.demo.Service.impl;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Good;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.OrderLine;
import com.example.demo.Entity.ReceiptLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Iterable<Order> findAll() {
        return orderRepository.findAll();
    }

    @Override
    public Order save(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public Order findOrderById(Integer id) throws NoSuchEntityException {
        Optional<Order> foundOrder = orderRepository.findById(id);
        return foundOrder.orElseThrow(()-> new NoSuchEntityException(String
                .format("The order with such id:%s doesn't exist!", id)));
    }

    @Override
    public void removeOrder(Order order) {
        orderRepository.delete(order);
    }

    public double getTotalSumOfOrder(List<OrderLine> orderLines){
        double sum = 0.0;
        for (OrderLine orderLine : orderLines){
            sum += orderLine.getPrice() * orderLine.getAmount();
        }
        return sum;
    }

    public List<OrderLine> buildGoods(OrderDto form, Integer id) throws NoSuchEntityException {
        List<OrderLine> orderLines = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : form.getProducts().entrySet()){
            OrderLine orderLine = new OrderLine();
            Good goodInLine = getGoodById(entry.getKey());
            orderLine.setAmount(entry.getValue());
            orderLine.setGoodId(entry.getKey());
            orderLine.setOrderId(id);
            orderLine.setPrice(goodInLine.getPrice());
            orderLine.setProviderId(form.getProviderId());
            orderLines.add(orderLine);
        }
        return orderLines;
    }

    public Order buildOrder(OrderDto form){
        Order order = new Order();
        order.setStatus("NOT CONFIRMED");
        order.setDate(new Timestamp(System.currentTimeMillis()));
        order.setUserId(form.getUserId());
        return order;
    }

    private Good getGoodById(final Integer id) throws NoSuchEntityException {
        Optional<Good> foundGood = goodRepository.findById(id);
        return foundGood.orElseThrow(()-> new NoSuchEntityException(String
                .format("The good with such id:%s doesn't exist!", id)));
    }
}
