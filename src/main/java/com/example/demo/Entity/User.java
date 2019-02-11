package com.example.demo.Entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //?
    private int id;

    private String name;

    private String email;

    private String surname;

    private int salary;

    private int department_id;

    private String password;

/*
    @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(name = "userroles", joinColumns = {
            @JoinColumn(name = "user_id")}, inverseJoinColumns = {
            @JoinColumn(name = "role_id")})
    private List roles;
    */

    public User(){

    }

    public User(String name, String surname, int salary, int department_id, String email, String password) {
        this.name = name;
        this.surname = surname;
        this.salary = salary;
        this.department_id = department_id;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public Integer getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(Integer department_id) {
        this.department_id = department_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
