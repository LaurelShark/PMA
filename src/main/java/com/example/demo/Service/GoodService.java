package com.example.demo.Service;

import com.example.demo.Entity.Good;

import javax.persistence.Id;
import java.util.List;
import java.util.Optional;

public interface GoodService {

    List<Good> findAll();

    Good save(Good good);

    Optional<Good> findById(Integer id);

    Good deleteById(Good good);
}
