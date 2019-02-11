package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "availability")
public class Availability {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int amount;

    private float price;

    private int good_id;

    private int min_amount;

    public Availability(){

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

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getGood_id() {
        return good_id;
    }

    public void setGood_id(int good_id) {
        this.good_id = good_id;
    }

    public int getMin_amount() {
        return min_amount;
    }

    public void setMin_amount(int min_amount) {
        this.min_amount = min_amount;
    }
}
