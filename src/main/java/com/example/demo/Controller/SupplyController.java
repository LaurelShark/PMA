package com.example.demo.Controller;

import com.example.demo.Dto.SupplyDto;
import com.example.demo.Entity.Supply;
import com.example.demo.Entity.SupplyLine;
import com.example.demo.Service.SupplyLineService;
import com.example.demo.Service.impl.SupplyServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.List;

@RestController
@RequestMapping("/supplies")
public class SupplyController {

    @Autowired
    private SupplyServiceImpl supplyService;

    @Autowired
    private SupplyLineService supplyLineService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public Iterable<Supply> findAll() {
        Iterable<Supply> supplies = null;
        try {
            supplies = supplyService.findAll();
        } catch (Exception e) {
            System.err.println(e);
        }
        return supplies;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Supply> createSupply(@Valid @RequestBody SupplyDto supplyDto) {
        HttpStatus httpStatus;
        try {
            Supply supply = supplyService.buildSupply(supplyDto);
            supplyService.save(supply);
            System.out.println(supply);
            List<SupplyLine> supplyLines = supplyService.buildSupplyLines(supplyDto, supply.getId());
            System.out.println(supplyLines);
            if (supplyLines.isEmpty()) {
                supplyService.removeSupplyById(supply.getId());
            }
            supply.setTotalSum(supplyService.getTotalSumOfOrder(supplyLines));
            for (SupplyLine supplyLine : supplyLines){
                supplyLineService.save(supplyLine);
            }
            httpStatus = HttpStatus.OK;
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            e.printStackTrace();
        }
        return new ResponseEntity<>(httpStatus);
    }

}
