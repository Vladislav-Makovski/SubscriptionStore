package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.AdvertiserViewModel;
import com.netcracker.edu.fapi.models.ProductViewModel;
import com.netcracker.edu.fapi.models.SubscriptionViewModel;
import com.netcracker.edu.fapi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/advertiser/delete")
public class AdvertiserController {

    @Autowired
    private AdvertiserDataService advertiserDataService;

    @Autowired
    private WalletDataService walletDataService;

    @Autowired
    private UserDetailsDataService userDetailsDataService;

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @Autowired
    private CatalogItemDataService catalogItemDataService;

    @Autowired
    private ProductDataService productDataService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdvertiser(@PathVariable String id) {
        AdvertiserViewModel user = advertiserDataService.getAdvertiserById(Integer.valueOf(id));
        List<ProductViewModel> prod = catalogItemDataService.getProductByAdvertiserId(user.getId());
        for (ProductViewModel deleteProduct:prod) {
            List<SubscriptionViewModel> sub = subscriptionDataService.getSubscriptionByProductId(deleteProduct.getId());
            for (SubscriptionViewModel deleteSub: sub) {
                subscriptionDataService.deleteSubscription(deleteSub.getId());
            }
            productDataService.deleteProduct(deleteProduct.getId());
        }
        advertiserDataService.deleteAdvertiserById(Integer.valueOf(id));
        walletDataService.deleteWalletById(user.getWalletId());
        userDetailsDataService.deleteUserDetailsById(user.getUserDetailsId());
    }
}
