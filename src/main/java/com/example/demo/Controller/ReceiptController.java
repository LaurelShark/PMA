package com.example.demo.Controller;



import com.example.demo.Dto.ReceiptDto;
import com.example.demo.Entity.Receipt;
import com.example.demo.Entity.ReceiptLine;
import com.example.demo.Exception.NoSuchEntityException;
import com.example.demo.Service.impl.ReceiptLineServiceImpl;
import com.example.demo.Service.impl.ReceiptServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/receipts")
public class ReceiptController {

    @Autowired
    private ReceiptServiceImpl receiptService;

    @Autowired
    private ReceiptLineServiceImpl receiptLineService;

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

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Receipt> createReceipt(@Valid @RequestBody ReceiptDto receiptDto){
        HttpStatus httpStatus;
        try {
            Receipt receipt = receiptService.buildReceipt(receiptDto);
            receiptService.save(receipt);
            Integer buildingReceiptId = receipt.getId();
            System.out.println(receipt);
            List<ReceiptLine> receiptLines = receiptService.buildGoods(receiptDto, buildingReceiptId);
            System.out.println(receiptLines);
            if (receiptLines.isEmpty()){
                // Memory not cleaned from empty list
                receiptService.removeReceipt(receipt);
            }
            receipt.setTotalSum(receiptService.getTotalSumOfReceipt(receiptLines));
            for (ReceiptLine receiptLine : receiptLines){
                receiptLineService.save(receiptLine);
            }
            httpStatus = HttpStatus.OK;
        }catch (NoSuchEntityException e){
            httpStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }



}
