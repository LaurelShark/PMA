package com.example.demo.Controller;

import com.example.demo.Entity.SupplyLine;
import com.example.demo.Service.impl.SupplyLineServiceImpl;
import com.sun.deploy.panel.ITreeNode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/supplylines")
public class SupplyLineController {

    @Autowired
    private SupplyLineServiceImpl supplyService;

    @GetMapping
    public Iterable<SupplyLine> findAll(){
        Iterable<SupplyLine> supplyLines = null;
        try{
            supplyLines = supplyService.findAll();
        }catch (Exception e){
            System.err.println(e);
        }
        return supplyLines;
    }
}
