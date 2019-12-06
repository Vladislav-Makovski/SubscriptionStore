package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.SaveProductViewModel;
import com.netcracker.edu.fapi.service.ProductDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ProductDataServiceImpl implements ProductDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public void saveNewProduct(SaveProductViewModel prod) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.postForEntity(backendServerUrl + "/api/product/create/new", prod, SaveProductViewModel.class);
    }
}
