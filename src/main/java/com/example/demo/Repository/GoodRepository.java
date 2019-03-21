package com.example.demo.Repository;

import com.example.demo.Entity.Good;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface GoodRepository extends CrudRepository<Good, Integer> {

    List<Good> findAll();

    Good save(Good good);

}
