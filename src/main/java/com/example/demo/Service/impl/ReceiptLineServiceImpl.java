package com.example.demo.Service.impl;

import com.example.demo.Entity.ReceiptLine;
import com.example.demo.Repository.ReceiptLineRepository;
import com.example.demo.Service.ReceiptLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReceiptLineServiceImpl implements ReceiptLineService {

    @Autowired
    private ReceiptLineRepository receiptLineRepository;

    @Override
    public ReceiptLine save(ReceiptLine receiptLine) {
        return receiptLineRepository.save(receiptLine);
    }
}
