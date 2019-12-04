package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.AdvertiserDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class AdvertiserDataServiceImpl implements AdvertiserDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public AdvertiserViewModel saveNewAdvertiser(RegistrationAdvertiserViewModel inf, WalletViewModel wallet, UserDetailsViewModel userDetails) {
        AdvertiserViewModel saveCustomer = new AdvertiserViewModel();
        saveCustomer.setName(inf.getName());
        saveCustomer.setUserDetailsId(userDetails.getId());
        saveCustomer.setWalletId(wallet.getId());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/new/advertiser/create", saveCustomer, AdvertiserViewModel.class).getBody();
    }
}
