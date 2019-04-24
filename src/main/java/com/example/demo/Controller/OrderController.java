package com.example.demo.Controller;


import com.example.demo.Dto.OrderDto;
import com.example.demo.Entity.Order;
import com.example.demo.Entity.OrderLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Repository.OrderLineRepository;
import com.example.demo.Service.impl.OrderLineServiceImpl;
import com.example.demo.Service.impl.OrderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderServiceImpl orderService;

    @Autowired
    private OrderLineServiceImpl orderLineService;


    // TEST
    @Autowired
    private OrderLineRepository orderLineRepository;

    @CrossOrigin(origins = "*")
    @GetMapping("/order/{id}")
    public Iterable<OrderLine> findOrderLinesByOrderId(@Valid @PathVariable Integer id){
        Iterable<OrderLine> orderLines = null;
        try{
            orderLines = orderLineRepository.foundOrderLinesByOrderId(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        return orderLines;
    }

    @CrossOrigin(origins = "*")
    @GetMapping
    public Iterable<Order> findAll() {
        Iterable<Order> orders = null;
        try{
            orders = orderService.findAll();
        }catch (Exception e){
            System.err.println(e);
        }
        return orders;
    }


    @CrossOrigin(origins = "*")
    @GetMapping("/{id}")
    public Order getOrderById(@Valid @PathVariable Integer id){
        Order order = null;
        try{
            order = orderService.findOrderById(id);
        } catch (NoSuchEntityException e) {
            e.printStackTrace();
        }
        return order;
    }


    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Order> createOrder(@Valid @RequestBody OrderDto orderDto) throws Exception{
        HttpStatus httpStatus;
        try{
            Order order = orderService.buildOrder(orderDto);
            orderService.save(order);
            List<OrderLine> orderLines = orderService.buildGoods(orderDto, order.getId());
            if (orderLines.isEmpty()){
                orderService.removeOrder(order.getId());
            }
            order.setTotalSum(orderService.getTotalSumOfOrder(orderLines));
            for (OrderLine orderLine : orderLines){
                orderLineService.save(orderLine);
            }
            httpStatus = HttpStatus.OK;
        } catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Order> updateOrder(@Valid @RequestBody OrderDto orderDto, @PathVariable Integer id) {
        HttpStatus httpStatus;
        try {
            orderService.updateOrder(orderDto, id);
            httpStatus = HttpStatus.OK;
        } catch (Exception e) {
            httpStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }


    @CrossOrigin(origins = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Order> deleteOrder(@Valid @PathVariable Integer id){
        HttpStatus httpStatus;
        try{
            orderService.removeOrder(id);
            httpStatus = HttpStatus.OK;
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }

}
