package com.example.demo.Service.impl;

import com.example.demo.Dto.SupplyDto;
import com.example.demo.Entity.Good;
import com.example.demo.Entity.Supply;
import com.example.demo.Entity.SupplyLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.SupplyLineRepository;
import com.example.demo.Repository.SupplyRepository;
import com.example.demo.Service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
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

    @Autowired
    private SupplyLineRepository supplyLineRepository;

    @Override
    public Iterable<Supply> findAll() {
        return supplyRepository.findAll();
    }

    @Override
    public Iterable<Supply> findSuppliesForMerchandiser(Integer id) {
        return supplyRepository.findAllByCreatedBy(id);
    }

    @Override
    public Supply findSupplyById(Integer id) throws NoSuchEntityException {
        Optional<Supply> foundSupply = supplyRepository.findById(id);
        return foundSupply.orElseThrow(()-> new NoSuchEntityException(String
                .format("The supply with such id:%s doesn't exist!", id)));
    }

    @Override
    public Supply findSupplyByIdAndMerchadiserId(Integer id, Integer merchandiserId) throws NoSuchEntityException {
        Supply foundSupplyByMerchandiserId = null;
        try {
            foundSupplyByMerchandiserId = supplyRepository.findMerchandiserSupplies(id, merchandiserId);
           // System.out.println(foundSupplyByMerchandiserId);
        } catch (Exception e){
            throw new NoSuchEntityException(String
                    .format("The supply with such id:%s," +
                            " created by merchadiser with id:%s doesn't exist!", id, merchandiserId));
        }
        return foundSupplyByMerchandiserId;
    }

    @Override
    public Supply save(Supply supply) {
        return supplyRepository.save(supply);
    }


    // Not Correct
    @Override
    public Supply updateMerchandiserSupply(SupplyDto supplyDto, Integer id, Integer merchandiserId) throws Exception {
        Supply foundSupply = null;
        try {
            foundSupply = findSupplyByIdAndMerchadiserId(id, merchandiserId);
            System.out.println(foundSupply);
            foundSupply.setDatetime(new Timestamp(System.currentTimeMillis()));
            if (supplyDto.getGoods() != null){
                Iterable<SupplyLine> iterableSupplyLines = supplyLineRepository.findAllBySupplyId(foundSupply.getId());
                List<SupplyLine> updatedSupplylines = new ArrayList<>();
                iterableSupplyLines.forEach(updatedSupplylines::add);
                int position = 0;
                double oldSum = getTotalSumOfSupply(updatedSupplylines);
                for (Map.Entry<Integer, Integer> entry : supplyDto.getGoods().entrySet()){
                    SupplyLine supplyLineToUpdate = updatedSupplylines.get(position);
                    supplyLineToUpdate.setGoodId(entry.getKey());
                    supplyLineToUpdate.setAmount(entry.getValue());
                    updatedSupplylines.add(supplyLineToUpdate);
                    supplyLineRepository.save(supplyLineToUpdate);
                    if (entry.getValue() < 0){
                        throw new Exception("Amount of goods cannot be less than zero!");
                    }
                    if (entry.getValue() == 0){
                        supplyLineRepository.deleteById(entry.getKey());
                    }
                }
                foundSupply.setTotalSum(getTotalSumOfSupply(updatedSupplylines) - oldSum);
                supplyRepository.save(foundSupply);
            }
        }catch (NoSuchEntityException e){
            e.printStackTrace();
        }
        return foundSupply;
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
        supply.setCreatedBy(supplyDto.getCreatedBy());
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

    public double getTotalSumOfSupply(List<SupplyLine> supplyLines){
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
