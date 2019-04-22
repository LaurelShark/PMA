package com.example.demo.Entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "receipts")
public class Receipt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private Timestamp datetime;

    private double totalSum;

    private int userId;

    public Receipt(){

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

    public double getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(double totalSum) {
        this.totalSum = totalSum;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "Receipt{" +
                "id=" + id +
                ", datetime=" + datetime +
                ", totalSum=" + totalSum +
                ", userId=" + userId +
                '}';
    }
}
