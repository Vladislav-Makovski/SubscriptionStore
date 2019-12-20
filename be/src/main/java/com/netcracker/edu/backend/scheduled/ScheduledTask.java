package com.netcracker.edu.backend.scheduled;

import com.netcracker.edu.backend.entity.*;
import com.netcracker.edu.backend.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@EnableScheduling
public class ScheduledTask {

    private SubscriptionService subscriptionService;

    private ProductService productService;

    private CustomerService customerService;

    private AdvertiserService advertiserService;

    private WalletService walletService;

    @Autowired
    public ScheduledTask(SubscriptionService subscriptionService,ProductService productService,
                         CustomerService customerService, AdvertiserService advertiserService,WalletService walletService) {
        this.subscriptionService = subscriptionService;
        this.productService = productService;
        this.customerService = customerService;
        this.advertiserService = advertiserService;
        this.walletService = walletService;
    }
    @Scheduled(cron="0 52 20 20 * ?")
//    @Scheduled(fixedRate = 500)
    public void reportCurrentTime() {
        List<Subscription> subs = subscriptionService.getAllSubscription();
        for (Subscription sub: subs) {
           Product prod = productService.getProductById(sub.getProductId()).orElse(new Product());
           Customer cust = customerService.getCustomerById(sub.getUserId()).orElse(new Customer());
           Organization org = advertiserService.getAdvertiserById(prod.getOrganizationId()).orElse(new Organization());
           Wallet custWallet = walletService.getWalletById(cust.getWalletId()).orElse(new Wallet());
           Wallet orgWallet =  walletService.getWalletById(org.getWalletId()).orElse(new Wallet());
           if(custWallet.getBalance() - prod.getCost() > 0){
               custWallet.setBalance(custWallet.getBalance() - prod.getCost());
               walletService.saveBalanceWithdraw(custWallet);
               orgWallet.setBalance(orgWallet.getBalance()+ prod.getCost());
               walletService.saveBalanceRecharge(orgWallet);
           }else{
               subscriptionService.deleteSubscription(sub.getId());
           }
        }
    }
}
