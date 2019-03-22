package com.example.demo.Service.impl;

import com.example.demo.Entity.Provider;
import com.example.demo.Repository.ProviderRepository;
import com.example.demo.Service.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProviderServiceImpl implements ProviderService {

    @Autowired
    private ProviderRepository providerRepository;

    @Override
    public Iterable<Provider> findAll() {
        return providerRepository.findAll();
    }
}
