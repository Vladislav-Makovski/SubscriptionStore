package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.Subscription;

public interface SubscriptionService {
    Iterable<Subscription> getSubscriptionByUserId(Integer id);
    Iterable<Subscription> getSubscriptionByProductId(Integer id);
    void deleteSubscription(Integer id);

}
