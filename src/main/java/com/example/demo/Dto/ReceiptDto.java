package com.example.demo.Dto;

import javax.validation.constraints.NotNull;
import java.sql.Timestamp;
import java.util.HashMap;

public class FuckinDto {

    private Timestamp date;

    @NotNull
    private Integer totalSum;

    @NotNull
    private Integer userId;

    @NotNull
    private HashMap<Integer, Integer> goods;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Integer getTotalSum() {
        return totalSum;
    }

    public void setTotalSum(Integer totalSum) {
        this.totalSum = totalSum;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public HashMap<Integer, Integer> getGoods() {
        return goods;
    }

    public void setGoods(HashMap<Integer, Integer> goods) {
        this.goods = goods;
    }
}
