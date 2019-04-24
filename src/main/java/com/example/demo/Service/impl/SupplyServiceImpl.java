package com.example.demo.Service.impl;

import com.example.demo.Dto.SupplyDto;
import com.example.demo.Entity.Good;
import com.example.demo.Entity.Supply;
import com.example.demo.Entity.SupplyLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.SupplyRepository;
import com.example.demo.Service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class SupplyServiceImpl implements SupplyService {

    @Autowired
    private SupplyRepository supplyRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Iterable<Supply> findAll() {
        return supplyRepository.findAll();
    }

    @Override
    public Supply save(Supply supply) {
        return supplyRepository.save(supply);
    }

    @Override
    public void removeSupplyById(Integer id) {
        supplyRepository.deleteById(id);
    }

    public Supply buildSupply(SupplyDto supplyDto){
        Supply supply = new Supply();
        supply.setProviderId(supplyDto.getProviderId());
        supply.setOrderId(supplyDto.getOrderId());
        supply.setDatetime(new Timestamp(System.currentTimeMillis()));
        return supply;
    }


    // TODO merchandisers can change price of goods
    public List<SupplyLine> buildSupplyLines(SupplyDto supplyDto, Integer id) throws NoSuchEntityException {
        List<SupplyLine> supplyLines = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : supplyDto.getGoods().entrySet()){
            SupplyLine supplyLine = new SupplyLine();
            Good goodInLine = getGoodById(entry.getKey());
            supplyLine.setGoodId(entry.getKey());
            supplyLine.setAmount(entry.getValue());
            supplyLine.setPrice(goodInLine.getPrice());
            supplyLine.setSupplyId(id);
            supplyLines.add(supplyLine);
        }
        return supplyLines;
    }

    public double getTotalSumOfOrder(List<SupplyLine> supplyLines){
        double sum = 0.0;
        for (SupplyLine supplyLine : supplyLines){
            sum += supplyLine.getPrice() * supplyLine.getAmount();
        }
        return sum;
    }

    private Good getGoodById(final Integer id) throws NoSuchEntityException {
        Optional<Good> foundGood = goodRepository.findById(id);
        return foundGood.orElseThrow(()-> new NoSuchEntityException(String
                .format("The good with such id:%s doesn't exist!", id)));
    }
}
