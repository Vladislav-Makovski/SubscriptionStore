package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.entity.Subscription;
import com.netcracker.edu.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    @RequestMapping(value = "/api/customerSubscription/{id}", method = RequestMethod.GET)
    public Iterable<Subscription> SubscriptionByUserId(@PathVariable(name = "id") Integer id) {
        return subscriptionService.getSubscriptionByUserId(id);
    }

    @RequestMapping(value = "/api/customerSubscription/delete/{id}", method = RequestMethod.DELETE)
    public void deleteSubscription(@PathVariable(name = "id") Integer id) {
       subscriptionService.deleteSubscription(id);
    }

    @GetMapping
    @RequestMapping(value = "/api/customerSubscription/product/{id}", method = RequestMethod.GET)
    public Iterable<Subscription> SubscriptionByProductId(@PathVariable(name = "id") Integer id) {
        return subscriptionService.getSubscriptionByProductId(id);
    }

    @RequestMapping(value = "/api/new/subscription/costumer", method = RequestMethod.POST)
    public void saveProduct(@RequestBody Subscription sub) {
        subscriptionService.saveNewSub(sub);
    }
}
