package com.netcracker.edu.fapi.controller;

import com.netcracker.edu.fapi.models.AdvertiserViewModel;
import com.netcracker.edu.fapi.service.AdvertiserDataService;
import com.netcracker.edu.fapi.service.UserDetailsDataService;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/advertiser/delete")
public class AdvertiserController {

    @Autowired
    private AdvertiserDataService advertiserDataService;

    @Autowired
    private WalletDataService walletDataService;

    @Autowired
    private UserDetailsDataService userDetailsDataService;

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAdvertiser(@PathVariable String id) {
        AdvertiserViewModel user = advertiserDataService.getAdvertiserById(Integer.valueOf(id));
        advertiserDataService.deleteAdvertiserById(Integer.valueOf(id));
        walletDataService.deleteWalletById(user.getWalletId());
        userDetailsDataService.deleteUserDetailsById(user.getUserDetailsId());
    }
}
