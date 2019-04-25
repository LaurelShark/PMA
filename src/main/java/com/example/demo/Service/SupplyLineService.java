package com.example.demo.Service;

import com.example.demo.Entity.SupplyLine;

public interface SupplyLineService {

    Iterable<SupplyLine> findAll();

    SupplyLine save(SupplyLine supplyLine);

    Iterable<SupplyLine> findSupplyLinesForSupply(Integer id);
}
