package com.example.demo.Service.impl;

import com.example.demo.Entity.SupplyLine;
import com.example.demo.Repository.SupplyLineRepository;
import com.example.demo.Service.SupplyLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplyLineServiceImpl implements SupplyLineService {

    @Autowired
    private SupplyLineRepository supplyLineRepository;

    @Override
    public Iterable<SupplyLine> findAll() {
        return supplyLineRepository.findAll();
    }
}
