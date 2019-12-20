package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SubscribeController {
    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @Autowired
    private WalletDataService walletDataService;

    @Autowired
    private ProductDataService productDataService;

    @Autowired
    private CustomerDataService customerDataService;

    @Autowired
    private AdvertiserDataService advertiserDataService;

    @RequestMapping(value = "/api/new/subscription/costumer/",method = RequestMethod.POST)
    public void saveNewProduct(@RequestBody SubscriptionViewModel prod) {
        CustomerViewModel cust = customerDataService.getCustomerById(prod.getUserId());
        WalletViewModel userWallet = walletDataService.getUserWalletById(cust.getWalletId());
        ProductViewModel subProduct = productDataService.getProductById(prod.getProductId());
        int adverId = productDataService.getAdvertiserByProductId(prod.getProductId());
        AdvertiserViewModel adver = advertiserDataService.getAdvertiserById(adverId);
        WalletViewModel adverWallet = walletDataService.getUserWalletById(adver.getWalletId());
        if(userWallet.getBalance()- subProduct.getCost() >= 0) {
            userWallet.setBalance(userWallet.getBalance()- subProduct.getCost());
            adverWallet.setBalance(adverWallet.getBalance() + subProduct.getCost());
            walletDataService.saveBalanceWithdraw(userWallet);
            walletDataService.saveBalanceRecharge(adverWallet);
            subscriptionDataService.subscribeProduct(prod);
        }
    }
}
