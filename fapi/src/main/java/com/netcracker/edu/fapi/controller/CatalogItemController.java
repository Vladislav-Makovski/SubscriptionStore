package com.netcracker.edu.fapi.controller;
import com.netcracker.edu.fapi.models.ProductViewModel;
import com.netcracker.edu.fapi.service.CatalogItemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class CatalogItemController {

    @Autowired
    private CatalogItemDataService productDataService;

    @RequestMapping("/api/bc")
    @GetMapping
    public ResponseEntity<List<ProductViewModel>> getAllProductBySubscriptionCount() {
        return ResponseEntity.ok(productDataService.getAllBySubscriptionCount());
    }

}
