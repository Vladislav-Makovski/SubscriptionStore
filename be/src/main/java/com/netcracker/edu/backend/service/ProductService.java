package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Product;

public interface ProductService {

    void saveProduct(Product product);
    void deleteProduct(Integer id);
    void changeStatusProduct(Product id);
}
