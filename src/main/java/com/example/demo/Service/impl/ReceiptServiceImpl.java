package com.example.demo.Service.impl;

import com.example.demo.Dto.ReceiptDto;
import com.example.demo.Entity.Good;
import com.example.demo.Entity.Receipt;
import com.example.demo.Entity.ReceiptLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Repository.GoodRepository;
import com.example.demo.Repository.ReceiptRepository;
import com.example.demo.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Autowired
    private GoodRepository goodRepository;

    @Override
    public Iterable<Receipt> findAll() {
        return receiptRepository.findAll();
    }

    @Override
    public Receipt save(Receipt receipt) {
        return receiptRepository.save(receipt);
    }

    @Override
    public void removeReceipt(Receipt receipt) {
        receiptRepository.delete(receipt);
    }

    public Receipt buildReceipt(ReceiptDto receiptDto){
        Receipt receipt = new Receipt();
        receipt.setDatetime(new Timestamp(System.currentTimeMillis()));
        receipt.setUserId(receiptDto.getUserId());
        return receipt;
    }

    public List<ReceiptLine> buildGoods(ReceiptDto receiptDto, Integer id) throws NoSuchEntityException {
        List<ReceiptLine> listOfGoods = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : receiptDto.getGoods().entrySet()){
            Good goodInLine = getGoodById(entry.getKey());
            ReceiptLine receiptLine = new ReceiptLine();
            receiptLine.setGoodId(entry.getKey());
            receiptLine.setReceiptId(id);
            receiptLine.setName(goodInLine.getName());
            receiptLine.setAmount(entry.getValue());
            receiptLine.setPrice(goodInLine.getPrice());
            if (goodInLine.getUniqueId() != null){
                receiptLine.setUniqueId(goodInLine.getUniqueId());
            }
            listOfGoods.add(receiptLine);
        }
        return listOfGoods;
    }

    public double getTotalSumOfReceipt(List<ReceiptLine> receiptLines){
        double sum = 0.0;
        for (ReceiptLine receiptLine : receiptLines){
            sum += receiptLine.getPrice() * receiptLine.getAmount();
        }
        return sum;
    }

    private Good getGoodById(final Integer id) throws NoSuchEntityException {
        Optional<Good> foundGood = goodRepository.findById(id);
        return foundGood.orElseThrow(()-> new NoSuchEntityException(String
                .format("The good with such id:%s doesn't exist!", id)));
    }
}
