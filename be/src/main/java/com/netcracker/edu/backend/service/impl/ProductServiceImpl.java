package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.repository.CatalogItemRepository;
import com.netcracker.edu.backend.repository.StatusWalletRepository;
import com.netcracker.edu.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductServiceImpl implements ProductService{

    private CatalogItemRepository repository;

    @Autowired
    public ProductServiceImpl(CatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public void saveProduct(Product product) {
        repository.save(product);
    }
}
