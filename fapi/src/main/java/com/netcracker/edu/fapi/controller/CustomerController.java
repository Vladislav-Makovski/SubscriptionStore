package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.CustomerViewModel;
import com.netcracker.edu.fapi.models.SubscriptionViewModel;
import com.netcracker.edu.fapi.service.CustomerDataService;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import com.netcracker.edu.fapi.service.UserDetailsDataService;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/customer/delete")
public class CustomerController {

    @Autowired
    private CustomerDataService customerDataService;

    @Autowired
    private WalletDataService walletDataService;

    @Autowired
    private UserDetailsDataService userDetailsDataService;

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteCustomer(@PathVariable String id) {
        CustomerViewModel user = customerDataService.getCustomerById(Integer.valueOf(id));
        List<SubscriptionViewModel> userSub = subscriptionDataService.getSubscriptionByUserId(user.getId());
        for (SubscriptionViewModel sub:userSub) {
            subscriptionDataService.deleteSubscription(sub.getId());
        }
        customerDataService.deleteCustomerById(Integer.valueOf(id));
        walletDataService.deleteWalletById(user.getWalletId());
        userDetailsDataService.deleteUserDetailsById(user.getUserDetailsId());
    }
    

}
