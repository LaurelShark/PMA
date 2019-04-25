package com.example.demo.Dto;

import javax.validation.constraints.NotNull;
import java.util.HashMap;

public class SupplyDto {

    private Integer providerId;

    private Integer orderId;

    private Integer amount;

    private Double price;

    private Double totalSum;

    private Integer createdBy;

    @NotNull
    public HashMap<Integer, Integer> goods;

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public HashMap<Integer, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Integer, Integer> goods) {
        this.goods = goods;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Double totalSum) {
        this.totalSum = totalSum;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "SupplyDto{" +
                "providerId=" + providerId +
                ", orderId=" + orderId +
                ", amount=" + amount +
                ", price=" + price +
                ", totalSum=" + totalSum +
                ", createdBy=" + createdBy +
                ", goods=" + goods +
                '}';
    }
}
