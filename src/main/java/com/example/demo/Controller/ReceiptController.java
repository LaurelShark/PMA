package com.example.demo.Controller;

import com.example.demo.Entity.Receipt;
import com.example.demo.Service.impl.ReceiptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptServiceImpl receiptService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public Iterable<Receipt> findAll(){
        Iterable<Receipt> receipts = null;
        try{
            receipts = receiptService.findAll();
        }catch (Exception e){
            System.err.println(e);
        }
        return receipts;
    }
}
