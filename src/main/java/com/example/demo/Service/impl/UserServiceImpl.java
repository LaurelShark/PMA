package com.example.demo.Service.impl;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User createUser(User input_user) {
        User user = userRepository.save(new User(input_user.getRole(), input_user.getName(), input_user.getSurname(),
                input_user.getSalary(), input_user.getDepartment_id(), input_user.getEmail()));
        return user;
    }

    @Override
    public boolean deleteUser(long id) {
        boolean flag = false;
        try {
            userRepository.deleteById(id);
            flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public List<User> findBySalary(int salary){
        List<User> users;
        users = userRepository.findBySalary(salary);
        return users;
    }
}
