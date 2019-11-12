package com.netcracker.edu.backend.service.impl;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.repository.CatalogItemRepository;
import com.netcracker.edu.backend.service.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class CatalogItemServiceImpl implements CatalogItemService {

    private CatalogItemRepository repository;

    @Autowired
    public CatalogItemServiceImpl(CatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public  Iterable<Product> getAllCatalogItem() {
        return repository.findAll();
    }
}



