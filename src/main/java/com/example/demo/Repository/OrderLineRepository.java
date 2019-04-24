package com.example.demo.Repository;

import com.example.demo.Entity.OrderLine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderLineRepository extends JpaRepository<OrderLine, Integer> {

    @Query("select o from OrderLine o where lower(o.orderId) = lower(:orderId)")
    Iterable<OrderLine> foundOrderLinesByOrderId(@Param("orderId") Integer orderId);

}
