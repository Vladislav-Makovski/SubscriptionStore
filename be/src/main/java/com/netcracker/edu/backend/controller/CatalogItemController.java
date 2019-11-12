package com.netcracker.edu.backend.controller;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.service.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@RestController
@RequestMapping("/api/catalog-item")
public class CatalogItemController {

    private CatalogItemService catalogItemService;

    @Autowired
    public CatalogItemController(CatalogItemService catalogItemService) {
        this.catalogItemService = catalogItemService;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public Iterable<Product> getAllCatalogItem() {
        return catalogItemService.getAllCatalogItem();
    }

}

