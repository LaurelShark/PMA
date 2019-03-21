package com.example.demo.Dto;

import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class GoodDto {

    @NotBlank(message = "Enter correct good name")
    @Size(max = 64, message = "Name must not be more than 64 characters long")
    private String name;

    @NotNull()
    @Range(min=1,message = "Enter correct categoryId")
    private int categoryId;

    @NotNull()
    @Range(min=1,message = "Enter correct departmentId")
    private int departmentId;

    @NotNull()
    @Range(min=1,message = "Enter correct amount")
    private int amount;

    @NotNull()
    @Range(min=1,message = "Enter min amount")
    private int minAmount;

    @NotNull()
    @Range(min=1,message = "Product should have price")
    private double price;

    private String uniqueId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getMinAmount() {
        return minAmount;
    }

    public void setMinAmount(int minAmount) {
        this.minAmount = minAmount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
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
        return "GoodDto{" +
                "name='" + name + '\'' +
                ", categoryId=" + categoryId +
                ", departmentId=" + departmentId +
                ", amount=" + amount +
                ", minAmount=" + minAmount +
                ", price=" + price +
                ", uniqueId='" + uniqueId + '\'' +
                '}';
    }
}
