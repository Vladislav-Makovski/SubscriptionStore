package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.CustomerDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

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
        return restTemplate.postForEntity(backendServerUrl + "/api/customer/new/create", saveCustomer, CustomerViewModel.class).getBody();
    }

    @Override
    public List<CustomerViewModel> getAllByNameAsc() {
        RestTemplate restTemplate = new RestTemplate();
        CustomerViewModel[] customerViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/customer/nameAsc", CustomerViewModel[].class);
        return customerViewModelResponse == null ? Collections.emptyList() : Arrays.asList(customerViewModelResponse);
    }

    @Override
    public void deleteCustomerById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/customer/delete/" + id);
    }

    @Override
    public CustomerViewModel getCustomerById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/customer/information/" + id, CustomerViewModel.class);
    }

    @Override
    public UserSignatureViewModel getCustomerByUserDetailsId(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/customer/information/userDetails/" + id, UserSignatureViewModel.class);
    }
}
