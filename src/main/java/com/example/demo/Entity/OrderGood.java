package com.example.demo.Entity;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
@Table(name = "orderlines")
public class OrderGood {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull()
    @Range(min=1,message = "Enter correct amount")
    private int amount;

    @NotNull()
    @Range(min=1,message = "Enter correct price")
    private int price;

    @NotNull()
    @Range(min=1,message = "Enter correct orderId")
    private int orderId;

    @NotNull()
    @Range(min=1,message = "Enter correct goodId")
    private int goodId;

    private int providerId;

    public OrderGood(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    @Override
    public String toString() {
        return "OrderGood{" +
                "id=" + id +
                ", amount=" + amount +
                ", price=" + price +
                ", orderId=" + orderId +
                ", goodId=" + goodId +
                ", providerId=" + providerId +
                '}';
    }
}
