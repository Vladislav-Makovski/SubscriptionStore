package com.netcracker.edu.backend.service.impl;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.repository.CatalogItemRepository;
import com.netcracker.edu.backend.service.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.naming.ldap.SortKey;
import java.util.Optional;

@Component
public class CatalogItemServiceImpl implements CatalogItemService {

    private CatalogItemRepository repository;
    Sort sort = Sort.by(Sort.Order.desc("SubscriptionCount"));

    @Autowired
    public CatalogItemServiceImpl(CatalogItemRepository repository) {
        this.repository = repository;
    }

    @Override
    public  Iterable<Product> getAllCatalogItemByName() {
        return repository.findAll(Sort.by("Name"));
    }

    @Override
    public  Iterable<Product> getAllCatalogItemByCategoryId() {
        return repository.findAll(Sort.by("CategoryId"));
    }

    @Override
    public  Iterable<Product> getAllCatalogItemBySubscriptionCount() {
        return repository.findAll(sort);
    }
}



