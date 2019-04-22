package com.example.demo.Controller;

import com.example.demo.Dto.CategoryDto;
import com.example.demo.Entity.Category;
import com.example.demo.Service.CategoryService;
import com.example.demo.Service.impl.CategoryServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryServiceImpl categoryServiceImpl;

    @CrossOrigin(origins = "*")
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


    @CrossOrigin(origins = "*")
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

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Category> createCategory(@Valid @RequestBody CategoryDto form) throws Exception{
        HttpStatus httpStatus;
        try {
            Category category = buildCategoryFromDto(form);
            categoryServiceImpl.save(category);
            httpStatus = HttpStatus.OK;
        } catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            System.err.println(e);
        }
        return new ResponseEntity<>(httpStatus);
    }

    private Category buildCategoryFromDto(CategoryDto form){
        Category category = new Category();
        category.setName(form.getName());
        return category;
    }

}
