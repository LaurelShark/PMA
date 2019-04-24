package com.example.demo.Service;

import com.example.demo.Entity.Supply;

public interface SupplyService {

    Iterable<Supply> findAll();

    Supply save(Supply supply);

    void removeSupplyById(Integer id);
}
