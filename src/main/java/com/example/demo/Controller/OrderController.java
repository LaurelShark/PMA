package com.example.demo.Controller;


import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.OrderGood;
import com.example.demo.Repository.OrderGoodRepository;
import com.example.demo.Repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderGoodRepository orderGoodRepository;

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderDto form) throws Exception{
        HttpStatus httpStatus = null;
        int orderId;
        Order tmpOrder;
        try{
            Order order = buildOrder(form);
            tmpOrder = orderRepository.save(order);
            orderId = tmpOrder.getId();
            List<OrderGood> orderGoods = buildGoodList(form, orderId);
            if (orderGoods.isEmpty()){
                orderRepository.delete(order);
                System.out.println("order deleted");
            }
            for (OrderGood orderGood : orderGoods){
                orderGoodRepository.save(orderGood);
            }
            httpStatus = HttpStatus.OK;
        } catch (Exception e){
            System.err.println(e);
            httpStatus = HttpStatus.BAD_REQUEST;
        }
        return new ResponseEntity<>(httpStatus);
    }


    private List<OrderGood> buildGoodList(OrderDto form, Integer id){
        List<OrderGood> orderGoods = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : form.getProducts().entrySet()){
            OrderGood orderGood = new OrderGood();
            orderGood.setAmount(entry.getValue());
            orderGood.setPrice(form.getPrice());
            orderGood.setGoodId(entry.getKey());
            orderGood.setOrderId(id);
            orderGood.setProviderId(form.getProviderId());
            orderGoods.add(orderGood);
        }
        return orderGoods;
    }

    // COUNT TOTAL PRICE, now is a stub

    private Order buildOrder(OrderDto form){
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        Order order = new Order();
        order.setStatus("NOT CONFIRMED");
        order.setDate(timestamp);
        order.setTotalSum(100);
        order.setUserId(form.getUserId());
        return order;
    }
}
