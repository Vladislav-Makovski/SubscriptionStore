package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.SubscriptionViewModel;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeController {
    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping(value = "/api/new/subscription/costumer/",method = RequestMethod.POST)
    public void saveNewProduct(@RequestBody SubscriptionViewModel prod) {
        subscriptionDataService.subscribeProduct(prod);
    }
}
