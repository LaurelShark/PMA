package com.example.demo.Repository;

import com.example.demo.Entity.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface CategoryRepository extends CrudRepository<Category, Long> {

    Category getCategoryByName(String name);

}
