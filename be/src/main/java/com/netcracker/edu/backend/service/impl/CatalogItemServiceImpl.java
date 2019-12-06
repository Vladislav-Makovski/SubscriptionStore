package com.netcracker.edu.backend.service.impl;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.entity.Subscription;
import com.netcracker.edu.backend.repository.CatalogItemRepository;
import com.netcracker.edu.backend.repository.ProductAdvertiserRepository;
import com.netcracker.edu.backend.service.CatalogItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Component;

import javax.naming.ldap.SortKey;
import java.util.Optional;

@Component
public class CatalogItemServiceImpl implements CatalogItemService {

    private CatalogItemRepository repository;
    private ProductAdvertiserRepository advertiserRepository;
    Sort sort = Sort.by(Sort.Order.desc("SubscriptionCount"));
    Sort sortNameDesc = Sort.by(Sort.Order.desc("Name"));
    Sort sortCategoryDesc = Sort.by(Sort.Order.desc("CategoryId"));
    Sort sortPriceDesc = Sort.by(Sort.Order.desc("Cost"));
    Pageable pageable = PageRequest.of(0, 2);

    @Autowired
    public CatalogItemServiceImpl(CatalogItemRepository repository,ProductAdvertiserRepository advRepository) {
        this.repository = repository;
        this.advertiserRepository = advRepository;
    }

    @Override
    public  Iterable<Product> getAllCatalogItemByNameAsc() {
        return repository.findAll(Sort.by("Name"));
    }

    @Override
    public  Iterable<Product> getAllCatalogItemByNameDesc() { return repository.findAll(sortNameDesc); }

    @Override
    public  Iterable<Product> getAllCatalogItemByCategoryIdAsc() {
        return repository.findAll(Sort.by("CategoryId"));
    }

    @Override
    public  Iterable<Product> getAllCatalogItemByCategoryIdDesc() {
        return repository.findAll(sortCategoryDesc);
    }

    @Override
    public  Iterable<Product> getAllCatalogItemByPriceAsc() {
        return repository.findAll(Sort.by("Cost"));
    }

    @Override
    public  Iterable<Product> getAllCatalogItemByPriceDesc() {
        return repository.findAll(sortPriceDesc);
    }

    @Override
    public  Iterable<Product> getAllCatalogItemBySubscriptionCount() {
        return repository.findAll(PageRequest.of(0, 1)).getContent();
    }

    @Override
    public Iterable<Product> getProductByAdvertiserId(Integer id){
        return advertiserRepository.findByOrganizationId(id);
    }
}



