package com.netcracker.edu.backend.controller;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.service.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
public class CatalogItemController {

    private CatalogItemService catalogItemService;

    @Autowired
    public CatalogItemController(CatalogItemService catalogItemService) {
        this.catalogItemService = catalogItemService;
    }

    @RequestMapping("/api/catalog-item/name")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByName()
    {
        return catalogItemService.getAllCatalogItemByName();
    }

    @RequestMapping("/api/catalog-item/category")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByCategoryId() {
        return catalogItemService.getAllCatalogItemByCategoryId();
    }

    @RequestMapping("/api/catalog-item/top")
    @GetMapping
    public Iterable<Product> getAllCatalogItemBySubscriptionCount() {
        return catalogItemService.getAllCatalogItemBySubscriptionCount();
    }
}

