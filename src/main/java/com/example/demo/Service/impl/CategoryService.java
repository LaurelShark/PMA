package com.example.demo.Service.impl;

import com.example.demo.Entity.Good;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements GoodService {

    @Autowired
    private GoodRepository goodRepository;

    @Override
    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    @Override
    public void save(Good good) {
        goodRepository.save(good);
    }

    @Override
    public Optional<Good> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Integer id) {

    }
}
