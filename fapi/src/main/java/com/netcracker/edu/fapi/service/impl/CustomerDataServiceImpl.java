package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CustomerViewModel;
import com.netcracker.edu.fapi.models.RegistrationCustomerViewModel;
import com.netcracker.edu.fapi.models.UserDetailsViewModel;
import com.netcracker.edu.fapi.models.WalletViewModel;
import com.netcracker.edu.fapi.service.CustomerDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public CustomerViewModel saveNewCustomer(RegistrationCustomerViewModel inf, WalletViewModel wallet, UserDetailsViewModel userDetails) {
        CustomerViewModel saveCustomer = new CustomerViewModel();
        saveCustomer.setFirstName(inf.getFirstName());
        saveCustomer.setSurname(inf.getSurname());
        saveCustomer.setUserDetailsId(userDetails.getId());
        saveCustomer.setWalletId(wallet.getId());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/new/customer/create", saveCustomer, CustomerViewModel.class).getBody();
    }
}
