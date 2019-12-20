package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.entity.Subscription;
import com.netcracker.edu.backend.repository.CatalogItemRepository;
import com.netcracker.edu.backend.repository.SubscriptionRepository;
import com.netcracker.edu.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepository;
    private CatalogItemRepository catalogItemRepository;
    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository repository,CatalogItemRepository catalogItemRepository) {
        this.subscriptionRepository = repository;
        this.catalogItemRepository = catalogItemRepository;
    }

    @Override
    public Iterable<Subscription> getSubscriptionByUserId(Integer id){
        return subscriptionRepository.findByUserId(id);
    }

    @Override
    public Iterable<Subscription> getSubscriptionByProductId(Integer id){
        return subscriptionRepository.findByProductId(id);
    }

    @Override
    public void deleteSubscription(Integer id) {
        subscriptionRepository.deleteById(id);
    }

    @Override
    public void saveNewSub(Subscription newSubscription) {
        newSubscription.setDateSub(Date.valueOf(LocalDate.now()));
        List<Subscription> sub = subscriptionRepository.findByUserId(newSubscription.getUserId());
        boolean canSave = true;
        for (Subscription subscription: sub) {
            if(subscription.getProductId() == newSubscription.getProductId()){
                canSave = false;
            }
        }
        if(canSave == true) {
            subscriptionRepository.save(newSubscription);
            Product product = catalogItemRepository.findById(newSubscription.getProductId()).orElse(new Product());
            product.setSubscriptionCount(product.getSubscriptionCount()+1);
            catalogItemRepository.save(product);
        }
    }

    @Override
    public List<Subscription> getAllSubscription() {
        return subscriptionRepository.findAll();
    }
}
