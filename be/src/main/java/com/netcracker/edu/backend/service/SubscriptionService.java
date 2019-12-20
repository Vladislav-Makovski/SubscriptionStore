package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subscription;

import java.util.List;

public interface SubscriptionService {
    Iterable<Subscription> getSubscriptionByUserId(Integer id);
    Iterable<Subscription> getSubscriptionByProductId(Integer id);
    void deleteSubscription(Integer id);
    void saveNewSub(Subscription product);
    List<Subscription> getAllSubscription();

}
