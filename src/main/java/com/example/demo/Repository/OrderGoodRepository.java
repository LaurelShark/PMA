package com.example.demo.Repository;

import com.example.demo.Entity.OrderGood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface OrderGoodRepository extends JpaRepository<OrderGood, Integer> {

}
