package com.example.demo.Dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashMap;

public class OrderDto {

    private int id;

    private String status;

    private Timestamp date;

    private int totalSum;

    private int userId;

    private int amount;

    private Double price;

    private int orderId;

    private int goodId;

    @NotNull()
    private HashMap<Integer, Integer> products;

    private int providerId;

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getGoodId() {
        return goodId;
    }

    public void setGoodId(int goodId) {
        this.goodId = goodId;
    }

    public HashMap<Integer, Integer> getProducts() {
        return products;
    }

    public void setProducts(HashMap<Integer, Integer> products) {
        this.products = products;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public int getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(int totalSum) {
        this.totalSum = totalSum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
