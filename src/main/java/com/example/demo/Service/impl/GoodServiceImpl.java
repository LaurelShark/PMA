package com.example.demo.Service.impl;

import com.example.demo.Entity.Good;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Service.GoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GoodServiceImpl implements GoodService {

    @Autowired
    private GoodRepository goodRepository;


    @Override
    public List<Good> findAll() {
        return goodRepository.findAll();
    }

    @Override
    public Good save(Good good) {
        return goodRepository.save(good);
    }

    @Override
    public Optional<Good> findById(Integer id) {
        return goodRepository.findById(id);
    }

    @Override
    public Good deleteById(Good good) {
       // return goodRepository.delete(good);
        return null;
    }
}
