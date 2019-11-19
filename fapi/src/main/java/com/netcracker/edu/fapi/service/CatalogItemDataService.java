package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ProductViewModel;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CatalogItemDataService {
    List<ProductViewModel> getAllByNameAsc();
    List<ProductViewModel> getAllByNameDesc();
    List<ProductViewModel> getAllByCategoryIdAsc();
    List<ProductViewModel> getAllByCategoryIdDesc();
    List<ProductViewModel> getAllByPriceAsc();
    List<ProductViewModel> getAllByPriceDesc();
    List<ProductViewModel> getAllBySubscriptionCount();
}
