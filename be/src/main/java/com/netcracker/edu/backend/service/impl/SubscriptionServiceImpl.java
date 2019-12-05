package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.Subscription;
import com.netcracker.edu.backend.repository.SubscriptionRepository;
import com.netcracker.edu.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SubscriptionServiceImpl implements SubscriptionService {
    private SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository repository) {
        this.subscriptionRepository = repository;
    }

    @Override
    public Iterable<Subscription> getSubscriptionByUserId(Integer id){
        return subscriptionRepository.findByUserId(id);
    }

    @Override
    public void deleteSubscription(Integer id) {
        subscriptionRepository.deleteById(id);
    }
}
