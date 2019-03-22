package com.example.demo.Service.impl;

import com.example.demo.Entity.Supply;
import com.example.demo.Repository.SupplyRepository;
import com.example.demo.Service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    @Override
    public Iterable<Supply> findAll() {
        return supplyRepository.findAll();
    }
}
