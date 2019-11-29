package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Subscription;
import com.netcracker.edu.backend.service.SubscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/customerSubscription/")
public class SubscriptionController {

    private SubscriptionService subscriptionService;

    @Autowired
    public SubscriptionController(SubscriptionService subscriptionService) {
        this.subscriptionService = subscriptionService;
    }

    @GetMapping
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Iterable<Subscription> SubscriptionByUserId(@PathVariable(name = "id") Integer id) {
        return subscriptionService.getSubscriptionByUserId(id);
    }
}
