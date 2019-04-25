package com.example.demo.Service.impl;

import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.User;
import com.example.demo.Entity.UserRole;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Repository.UserRoleRepository;
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

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @Override
    public User createUser(UserDto userDto) {
        User user = buildUser(userDto);
        userRepository.save(user);
        addDefaultRoleToUser(user.getId());
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

    private User buildUser(UserDto userDto){
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        user.setSalary(userDto.getSalary());
        user.setDepartment_id(userDto.getDepartmentId());
        user.setEmail(userDto.getEmail());
        user.setPassword(userDto.getPassword());
        return user;
    }

    private void addDefaultRoleToUser(Integer id){
        UserRole userRole = new UserRole();
        userRole.setUserId(id);
        userRole.setRoleId(1);
        userRoleRepository.save(userRole);
    }

}
