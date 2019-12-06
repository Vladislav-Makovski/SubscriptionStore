package com.netcracker.edu.fapi.controller;


import com.netcracker.edu.fapi.models.SaveProductViewModel;
import com.netcracker.edu.fapi.service.ProductDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/product/new/")
public class ProductController {

    @Autowired
    private ProductDataService productDataService;


    @RequestMapping(method = RequestMethod.POST)
    public void saveNewProduct(@RequestBody SaveProductViewModel prod) {
        productDataService.saveNewProduct(prod);
    }

}
