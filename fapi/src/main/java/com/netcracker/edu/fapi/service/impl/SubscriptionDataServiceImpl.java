package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SubscriptionViewModel;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class SubscriptionDataServiceImpl implements SubscriptionDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<SubscriptionViewModel> getSubscriptionByUserId(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        SubscriptionViewModel[] subscriptionViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/customerSubscription/" + id, SubscriptionViewModel[].class);
        return subscriptionViewModelResponse == null ? Collections.emptyList() : Arrays.asList(subscriptionViewModelResponse);
    }
}
