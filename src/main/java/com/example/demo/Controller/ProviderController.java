package com.example.demo.Controller;


import com.example.demo.Entity.Provider;
import com.example.demo.Service.impl.ProviderServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/providers")
public class ProviderController {

    @Autowired
    private ProviderServiceImpl providerService;

    @CrossOrigin(origins = "*")
    @GetMapping
    public Iterable<Provider> findAll(){
        Iterable<Provider> providers = null;
        try{
            providers = providerService.findAll();
        }catch (Exception e){
            System.err.println(e);
        }
        return providers;
    }
}
