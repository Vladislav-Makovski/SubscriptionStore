package com.netcracker.edu.backend.service;
import com.netcracker.edu.backend.entity.Product;
import java.util.Optional;

public interface CatalogItemService {
    Iterable<Product> getAllCatalogItemByNameAsc();
    Iterable<Product> getAllCatalogItemByNameDesc();
    Iterable<Product> getAllCatalogItemByCategoryIdAsc();
    Iterable<Product> getAllCatalogItemByCategoryIdDesc();
    Iterable<Product> getAllCatalogItemByPriceAsc();
    Iterable<Product> getAllCatalogItemByPriceDesc();
    Iterable<Product> getAllCatalogItemBySubscriptionCount();
}
