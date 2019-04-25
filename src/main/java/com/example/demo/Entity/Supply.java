package com.example.demo.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "supplies")
public class Supply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp datetime;

    private int providerId;

    private double totalSum;

    private int orderId;

    private Integer createdBy;

    public Supply(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getDatetime() {
        return datetime;
    }

    public void setDatetime(Timestamp datetime) {
        this.datetime = datetime;
    }

    public int getProviderId() {
        return providerId;
    }

    public void setProviderId(int providerId) {
        this.providerId = providerId;
    }

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    @Override
    public String toString() {
        return "Supply{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", providerId=" + providerId +
                ", totalSum=" + totalSum +
                ", orderId=" + orderId +
                ", createdBy=" + createdBy +
                '}';
    }
}
