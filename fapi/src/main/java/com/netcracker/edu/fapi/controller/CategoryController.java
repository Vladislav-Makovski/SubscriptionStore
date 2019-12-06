package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CategoryViewModel;
import com.netcracker.edu.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bi")
public class CategoryController {

    @Autowired
    private CategoryDataService categoryDataService;

    @GetMapping
    public ResponseEntity<List<CategoryViewModel>> getAllCategory() {
        return ResponseEntity.ok(categoryDataService.getAll());
    }
}
