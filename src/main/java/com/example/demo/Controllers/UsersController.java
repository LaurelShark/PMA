package com.example.demo.Controllers;

import com.example.demo.Entity.User;
import com.example.demo.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/all")
    public List<User> getAllUsers(){
        List<User> users = new ArrayList<>();
        userRepository.findAll().forEach(users::add);
        return users;
    }

    @PostMapping("/create")
    public User createUser(@RequestBody User input_user){

        User user = userRepository.save(new User(input_user.getRole(), input_user.getName(), input_user.getSurname(),
                input_user.getSalary(), input_user.getDepartment_id()));
        return user;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") long id){
        userRepository.deleteById(id);
        return new ResponseEntity<>("User was deleted!", HttpStatus.OK);
    }

}
