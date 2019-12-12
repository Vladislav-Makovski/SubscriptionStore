package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.StatusProduct;
import com.netcracker.edu.backend.repository.StatusProductRepository;
import com.netcracker.edu.backend.service.StatusProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class StatusProductServiceImpl implements StatusProductService{

    private StatusProductRepository repository;

    @Autowired
    public StatusProductServiceImpl(StatusProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public  Iterable<StatusProduct> getAllStatusProduct() {
        return repository.findAll();
    }

}
