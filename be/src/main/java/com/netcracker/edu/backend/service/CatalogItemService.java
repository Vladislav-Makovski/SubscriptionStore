package com.netcracker.edu.backend.service;
import com.netcracker.edu.backend.entity.Product;
import java.util.Optional;

public interface CatalogItemService {
    Iterable<Product> getAllCatalogItemByName();
    Iterable<Product> getAllCatalogItemByCategoryId();
    Iterable<Product> getAllCatalogItemBySubscriptionCount();
}
