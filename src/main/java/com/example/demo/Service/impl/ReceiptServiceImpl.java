package com.example.demo.Service.impl;

import com.example.demo.Entity.Receipt;
import com.example.demo.Repository.ReceiptRepository;
import com.example.demo.Service.ReceiptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptServiceImpl implements ReceiptService {

    @Autowired
    private ReceiptRepository receiptRepository;

    @Override
    public Iterable<Receipt> findAll() {
        return receiptRepository.findAll();
    }
}
