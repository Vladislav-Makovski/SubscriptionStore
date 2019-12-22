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
import java.util.*;

@Component
public class CatalogItemServiceImpl implements CatalogItemService {

    private ProductAdvertiserRepository productAdvertiserRepository;
    private CatalogItemRepository repository;
    private ProductAdvertiserRepository advertiserRepository;
    Sort sortProd = Sort.by(Sort.Order.desc("SubscriptionCount"));
    Sort sortNameDesc = Sort.by(Sort.Order.desc("Name"));
    Sort sortCategoryDesc = Sort.by(Sort.Order.desc("CategoryId"));
    Sort sortPriceDesc = Sort.by(Sort.Order.desc("Cost"));
    Pageable pageable = PageRequest.of(0, 2);

    @Autowired
    public CatalogItemServiceImpl(CatalogItemRepository repository,ProductAdvertiserRepository advRepository,ProductAdvertiserRepository productAdvertiserRepository) {
        this.repository = repository;
        this.advertiserRepository = advRepository;
        this.productAdvertiserRepository = productAdvertiserRepository;
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
        List<Product> prod = advertiserRepository.findByStatusProductId(1);
        Collections.sort(prod, new Comparator<Product>() {
            @Override
            public int compare(Product prod1, Product prod2) {
                return prod1.getSubscriptionCount() > prod2.getSubscriptionCount() ? -1 : (prod1.getSubscriptionCount() < prod2.getSubscriptionCount()) ? 1 : 0;
            }
        });
        if(prod.size() > 10) {
            while (prod.size() != 10) {
                prod.remove(prod.size() - 1);
            }
        }
        return prod;
    }

    @Override
    public Iterable<Product> getProductByAdvertiserId(Integer id){
        return advertiserRepository.findByOrganizationId(id);
    }

    @Override
    public Iterable<Product> getAllNewProduct() {
        return productAdvertiserRepository.findByStatusProductId(3);
    }

    @Override
    public void confirmNewProduct(Product id) {
        Product product = repository.findById(id.getId()).orElse(new Product());
        product.setStatusProductId(1);
        repository.save(product);
    }
}



