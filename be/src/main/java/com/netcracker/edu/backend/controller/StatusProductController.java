package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.StatusProduct;
import com.netcracker.edu.backend.service.StatusProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/statusProduct/all")
public class StatusProductController {
    private StatusProductService statusProductService;

    @Autowired
    public StatusProductController(StatusProductService statusProductService) {
        this.statusProductService = statusProductService;
    }

    @GetMapping
    public Iterable<StatusProduct> getAllCategory() {
        return statusProductService.getAllStatusProduct();
    }

}
