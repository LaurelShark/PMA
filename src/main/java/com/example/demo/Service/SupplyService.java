package com.example.demo.Service;

import com.example.demo.Dto.SupplyDto;
import com.example.demo.Entity.Supply;
import com.example.demo.Exception.NoSuchEntityException;

public interface SupplyService {

    Iterable<Supply> findAll();

    Iterable<Supply> findSuppliesForMerchandiser(Integer id);

    Supply findSupplyById(Integer id) throws NoSuchEntityException;

    Supply findSupplyByIdAndMerchadiserId(Integer id, Integer merchandiserId) throws NoSuchEntityException;

    Supply save(Supply supply);

    Supply updateMerchandiserSupply(SupplyDto supplyDto, Integer id, Integer merchandiserId) throws Exception;

    void removeSupplyById(Integer id);
}
