package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Product;

import java.util.Optional;

public interface ProductService {

    void saveProduct(Product product);
    void deleteProduct(Integer id);
    void changeStatusProduct(Product id);
    Optional<Product> getProductById(Integer id);
    Integer getAdvertiserIdById(Integer id);
}
