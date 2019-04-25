package com.example.demo.Controller;

import com.example.demo.Dto.UserDto;
import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.jws.soap.SOAPBinding;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserServiceImpl userServiceImpl;

    @CrossOrigin(origins = "*")
    @GetMapping()
    public List<User> getAllUsers(){
        List<User> users = null;
        try{
            users = userServiceImpl.getAllUsers();
        } catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @GetMapping("/salary={salary}")
    public List<User> findBySalary(@PathVariable("salary") int salary){
        List<User> users = null;
        try {
            users = userServiceImpl.findBySalary(salary);
        }catch (Exception e){
            e.printStackTrace();
        }
        return users;
    }

    @PostMapping
    public ResponseEntity<User> createUser(@Valid @RequestBody UserDto userDto){
        HttpStatus httpStatus;
        try{
            userServiceImpl.createUser(userDto);
            httpStatus = HttpStatus.OK;
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id) throws Exception{
        boolean flag = false;
        try{
            flag = userServiceImpl.deleteUser(id);
        }catch (Exception e){
            e.printStackTrace();
        }
        if(flag){
            return new ResponseEntity<>("User was deleted!", HttpStatus.OK);
        }else {
            throw new Exception("User wasnt deleted!");
        }
    }

}
