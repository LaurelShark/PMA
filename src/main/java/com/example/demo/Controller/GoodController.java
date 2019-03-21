package com.example.demo.Controller;


import com.example.demo.Dto.GoodDto;
import com.example.demo.Entity.Good;
import com.example.demo.Repository.GoodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/goods")
public class GoodController {

    @Autowired
    private GoodRepository goodRepository;

    @CrossOrigin(origins = "*")
    @RequestMapping
    public Iterable<Good> getAll(){
        Iterable<Good> goods = null;
        try{
            goods = goodRepository.findAll();
        } catch (Exception e){
            System.err.println(e);
        }
        return goods;
    }

    @CrossOrigin(origins = "*")
    @PostMapping
    public ResponseEntity<Good> createGood(@Valid @RequestBody GoodDto form) throws Exception {
        HttpStatus httpStatus = null;
        try{
            Good good = buildGood(form);
            goodRepository.save(good);
            httpStatus = HttpStatus.OK;
        } catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            System.err.println(e);
        }
        return new ResponseEntity<>(httpStatus);
    }

    @CrossOrigin(origins = "*")
    @PutMapping("/{id}")
    public ResponseEntity<Good> updateGood(@RequestBody Good good, @PathVariable Integer id){
        Optional<Good> goodOptional = goodRepository.findById(id);
        if (!goodOptional.isPresent()){
            return ResponseEntity.notFound().build();
        }
        good.setId(id);
        goodRepository.save(good);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin(origins = "*")
    @DeleteMapping("/{id}")
    public ResponseEntity deleteGood(@PathVariable Integer id){
        HttpStatus httpStatus = null;
        try {
            goodRepository.deleteById(id);
            httpStatus = HttpStatus.OK;
        }catch (Exception e){
            httpStatus = HttpStatus.BAD_REQUEST;
            System.err.println(e);
        }
        return ResponseEntity.status(httpStatus).build();
    }

    private Good buildGood(GoodDto form){
        Good good = new Good();
        good.setName(form.getName());
        good.setCategoryId(form.getCategoryId());
        good.setDepartmentId(form.getDepartmentId());
        good.setAmount(form.getAmount());
        good.setMinAmount(form.getMinAmount());
        good.setPrice(form.getPrice());
        if (form.getUniqueId() != null){
            good.setUniqueId(form.getUniqueId());
        }
        return good;
    }

}
