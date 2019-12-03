package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CustomerViewModel;
import com.netcracker.edu.fapi.models.NewCustomerViewModel;
import com.netcracker.edu.fapi.service.CustomerDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CustomerDataServiceImpl implements CustomerDataService {
    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public CustomerViewModel saveNewCustomer(NewCustomerViewModel customer) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/new/customer/create", customer, CustomerViewModel.class).getBody();
    }
}
