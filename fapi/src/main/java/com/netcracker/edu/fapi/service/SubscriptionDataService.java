package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.SubscriptionViewModel;

import java.util.List;

public interface SubscriptionDataService {
    List<SubscriptionViewModel> getSubscriptionByUserId(Integer id);
    void deleteSubscription(Integer id);
    List<SubscriptionViewModel> getSubscriptionByProductId(Integer id);

}
