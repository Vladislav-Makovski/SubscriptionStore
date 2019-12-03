package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CustomerViewModel;
import com.netcracker.edu.fapi.models.NewUserDetailsViewModel;
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
    public UserDetailsViewModel saveNewUserDetails(UserDetailsViewModel userDetails) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForEntity(backendServerUrl + "/api/new/userDetails", userDetails, UserDetailsViewModel.class).getBody();
    }
}
