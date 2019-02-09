package com.example.demo.Service;

import com.example.demo.Entity.User;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService  {

    List<User> getAllUsers();

    User createUser(User user);

    boolean deleteUser(long id);

    List<User> findBySalary(int salary);
}
