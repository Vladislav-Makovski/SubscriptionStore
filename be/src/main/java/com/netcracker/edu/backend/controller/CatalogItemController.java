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

    @RequestMapping("/api/catalog-item/nameAsc")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByNameAsc()
    {
        return catalogItemService.getAllCatalogItemByNameAsc();
    }

    @RequestMapping("/api/catalog-item/nameDesc")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByNameDesc()
    {
        return catalogItemService.getAllCatalogItemByNameDesc();
    }

    @RequestMapping("/api/catalog-item/categoryAsc")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByCategoryIdAsc() {
        return catalogItemService.getAllCatalogItemByCategoryIdAsc();
    }

    @RequestMapping("/api/catalog-item/categoryDesc")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByCategoryIdDesc() {
        return catalogItemService.getAllCatalogItemByCategoryIdDesc();
    }

    @RequestMapping("/api/catalog-item/priceAsc")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByPriceAsc() {
        return catalogItemService.getAllCatalogItemByPriceAsc();
    }

    @RequestMapping("/api/catalog-item/priceDesc")
    @GetMapping
    public Iterable<Product> getAllCatalogItemByPriceDesc() {
        return catalogItemService.getAllCatalogItemByPriceDesc();
    }



    @RequestMapping("/api/catalog-item/top")
    @GetMapping
    public Iterable<Product> getAllCatalogItemBySubscriptionCount() {
        Iterable<Product> a = catalogItemService.getAllCatalogItemBySubscriptionCount();
        return a;
    }
}

