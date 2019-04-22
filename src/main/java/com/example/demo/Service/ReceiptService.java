package com.example.demo.Service;

import com.example.demo.Entity.Receipt;

public interface ReceiptService {

    Iterable<Receipt> findAll();

    Receipt save(Receipt receipt);

    void removeReceipt(Receipt receipt);
}
