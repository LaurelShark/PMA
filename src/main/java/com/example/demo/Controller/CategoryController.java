package com.example.demo.Controller;

import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @GetMapping
    public Iterable<Category> getAll(){
        Iterable<Category> categories = null;
        try {
            categories = categoryServiceImpl.findAll();
        }catch (Exception e){
            System.err.println(e);
        }
        return categories;
    }

    @GetMapping("/name={name}")
    public Category getCategoryByName(@PathVariable("name") String name){
        Category category = null;
        try {
            category = categoryServiceImpl.getCategoryByName(name);
        }catch (Exception e){
            e.printStackTrace();
        }
        return category;
    }
}
