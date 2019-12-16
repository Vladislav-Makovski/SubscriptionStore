package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.UserDetailsViewModel;
import com.netcracker.edu.fapi.models.UserSignatureViewModel;
import com.netcracker.edu.fapi.service.UserInformationService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserInformationServiceImpl implements UserInformationService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public UserDetailsViewModel getUserByUsername(String username) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/user/signature/" + username, UserDetailsViewModel .class);
    }
}
