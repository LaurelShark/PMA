package com.example.demo.Controller;

import com.example.demo.Entity.Supply;
import com.example.demo.Service.impl.SupplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplies")
public class SupplyController {

    @Autowired
    private SupplyServiceImpl supplyService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public Iterable<Supply> findAll(){
        Iterable<Supply> supplies = null;
        try{
            supplies = supplyService.findAll();
        }catch (Exception e){
            System.err.println(e);
        }
        return supplies;
    }

}
