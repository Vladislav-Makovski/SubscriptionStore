package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.repository.CatalogItemRepository;
import com.netcracker.edu.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

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

    @Override
    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }

    @Override
    public void changeStatusProduct(Product id) {
        Product product = repository.findById(id.getId()).orElse(new Product());
        product.setStatusProductId(2);
        repository.save(product);
    }

    @Override
    public Optional<Product> getProductById(Integer id) {
            return repository.findById(id);
    }

    @Override
    public Integer getAdvertiserIdById(Integer id) {
        Product prod = repository.findById(id).orElse(new Product());
        return prod.getOrganizationId();
    }
}
