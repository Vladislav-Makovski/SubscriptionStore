package com.netcracker.edu.fapi.service.impl;
import com.netcracker.edu.fapi.models.ProductViewModel;
import com.netcracker.edu.fapi.service.CatalogItemDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class CatalogItemDataServiceImpl implements CatalogItemDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<ProductViewModel> getAllByName() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/name", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllByCategoryId() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/category", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllBySubscriptionCount() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/top", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }
}