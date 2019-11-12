package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ProductViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatalogItemDataService {
    List<ProductViewModel> getAll();
}
