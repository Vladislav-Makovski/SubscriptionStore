package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController(ProductService product) {
        this.productService = product;
    }

    @RequestMapping(value = "/api/product/create/new", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Product product) {
        productService.saveProduct(product);
    }

    @RequestMapping(value = "/api/product/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable(name = "id") Integer id) {
        productService.deleteProduct(id);
    }

    @RequestMapping(value = "/api/product/changeStatus/pause", method = RequestMethod.POST)
    public void changeStatusProduct(@RequestBody Product product) {
        productService.changeStatusProduct(product);
    }
}