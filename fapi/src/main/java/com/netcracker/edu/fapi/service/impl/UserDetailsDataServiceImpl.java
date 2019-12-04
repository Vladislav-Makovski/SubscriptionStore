package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.RegistrationAdvertiserViewModel;
import com.netcracker.edu.fapi.models.RegistrationCustomerViewModel;
import com.netcracker.edu.fapi.models.UserDetailsViewModel;
import com.netcracker.edu.fapi.service.UserDetailsDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserDetailsDataServiceImpl implements UserDetailsDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public UserDetailsViewModel saveNewUserDetailsCustomer(RegistrationCustomerViewModel inf) {
        UserDetailsViewModel userDetails = new UserDetailsViewModel();
        userDetails.setEmail(inf.getEmail());
        userDetails.setPassword(inf.getPassword());
        userDetails.setUsername(inf.getUsername());
        userDetails.setUserRoleId(inf.getUserRoleId());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/new/customer/userDetails", userDetails, UserDetailsViewModel.class).getBody();
    }

    @Override
    public UserDetailsViewModel saveNewUserDetailsAdvertiser(RegistrationAdvertiserViewModel inf) {
        UserDetailsViewModel userDetails = new UserDetailsViewModel();
        userDetails.setEmail(inf.getEmail());
        userDetails.setPassword(inf.getPassword());
        userDetails.setUsername(inf.getUsername());
        userDetails.setUserRoleId(inf.getUserRoleId());
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/new/advertiser/userDetails", userDetails, UserDetailsViewModel.class).getBody();
    }

}
