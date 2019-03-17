package com.example.demo.Service;

import com.example.demo.Entity.Category;

import java.util.List;

public interface CategoryService {

    Category getCategoryByName(String name);

    Iterable<Category> findAll();
}
