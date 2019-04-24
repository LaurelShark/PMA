package com.example.demo.Service.impl;

import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Good;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.OrderLine;
import com.example.demo.Entity.ReceiptLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.OrderRepository;
import com.example.demo.Service.OrderLineService;
import com.example.demo.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.*;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Autowired
    private OrderLineService orderLineService;

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
    public Order updateOrder(OrderDto orderDto, Integer id) throws Exception {
        Order foundOrder = orderRepository.findById(id)
                .orElseThrow(() -> new NoSuchEntityException(String
                        .format("The order with such id:%s doesn't exist!", id)));
        foundOrder.setDate(new Timestamp(System.currentTimeMillis()));
        if (orderDto.getProducts() != null) {
            List<OrderLine> updatedOrderLines = orderLineService.findOrderLinesByOrderId(id);
            int position = 0;
            for (Map.Entry<Integer, Integer> entry : orderDto.getProducts().entrySet()) {
                OrderLine orderLineToUpdate = updatedOrderLines.get(position);
                position++;
                orderLineToUpdate.setAmount(entry.getValue());
                updatedOrderLines.add(orderLineToUpdate);
                orderLineService.save(orderLineToUpdate);
                if (entry.getValue() < 0){
                    throw new Exception("Amount of products cannot be less than zero!");
                }
                if (entry.getValue() == 0){
                    orderLineService.removeOrderLine(entry.getKey());
                }
            }
            foundOrder.setTotalSum(getTotalSumOfOrder(updatedOrderLines));
            orderRepository.save(foundOrder);
        }
        return foundOrder;
    }

    @Override
    public void removeOrder(Integer id) {
        orderRepository.deleteById(id);
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
