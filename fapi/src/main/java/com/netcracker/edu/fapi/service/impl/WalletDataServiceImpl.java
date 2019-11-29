package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.StatusWalletViewModel;
import com.netcracker.edu.fapi.models.WalletViewModel;
import com.netcracker.edu.fapi.service.WalletDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class WalletDataServiceImpl implements WalletDataService{
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<StatusWalletViewModel> getWalletStatus() {
        RestTemplate restTemplate = new RestTemplate();
        StatusWalletViewModel[] statusWalletViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/walletStatus/", StatusWalletViewModel[].class);
        return statusWalletViewModelResponse == null ? Collections.emptyList() : Arrays.asList(statusWalletViewModelResponse);
    }

    @Override
    public WalletViewModel getUserWalletById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/wallet/" + id, WalletViewModel.class);
    }

    @Override
    public WalletViewModel saveBalanceRecharge(WalletViewModel wallet){
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/wallet/recharge", wallet, WalletViewModel.class).getBody();
    }

    @Override
    public  WalletViewModel saveBalanceWithdraw(WalletViewModel wallet){
        RestTemplate restTemplate = new RestTemplate();
        return  restTemplate.postForEntity(backendServerUrl + "/api/wallet/withdraw",wallet, WalletViewModel.class).getBody();
    }
}
