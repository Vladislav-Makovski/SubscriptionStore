package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/product/create")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService product) {
        this.productService = product;
    }

    @RequestMapping(value = "/new",method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

}
