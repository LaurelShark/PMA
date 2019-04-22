package com.example.demo.Entity;

import javax.persistence.*;

@Entity
@Table(name = "receiptlines")
public class ReceiptLine {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Integer goodId;

    private Integer receiptId;

    private String name;

    private Integer amount;

    private Double price;

    private String uniqueId;

    public ReceiptLine(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getGoodId() {
        return goodId;
    }

    public void setGoodId(Integer goodId) {
        this.goodId = goodId;
    }

    public Integer getReceiptId() {
        return receiptId;
    }

    public void setReceiptId(Integer receiptId) {
        this.receiptId = receiptId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getUniqueId() {
        return uniqueId;
    }

    public void setUniqueId(String uniqueId) {
        this.uniqueId = uniqueId;
    }

    @Override
    public String toString() {
        return "ReceiptLine{" +
                "id=" + id +
                ", goodId=" + goodId +
                ", receiptId=" + receiptId +
                ", name='" + name + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                ", uniqueId='" + uniqueId + '\'' +
                '}';
    }
}
