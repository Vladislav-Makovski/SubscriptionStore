package com.netcracker.edu.fapi.service.impl;
import com.netcracker.edu.fapi.models.ProductViewModel;
import com.netcracker.edu.fapi.models.SubscriptionViewModel;
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
    public List<ProductViewModel> getAllByNameAsc() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/nameAsc", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllByNameDesc() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/nameDesc", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllByCategoryIdAsc() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/categoryAsc", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllByCategoryIdDesc() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/categoryDesc", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllByPriceAsc() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/priceAsc", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllByPriceDesc() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/priceDesc", ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getAllBySubscriptionCount() {
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/catalog-item/top", ProductViewModel[].class);

        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

    @Override
    public List<ProductViewModel> getProductByAdvertiserId(Integer id){
        RestTemplate restTemplate = new RestTemplate();
        ProductViewModel[] productViewModelResponse = restTemplate.getForObject(backendServerUrl + "/api/advertiser/product/" + id, ProductViewModel[].class);
        return productViewModelResponse == null ? Collections.emptyList() : Arrays.asList(productViewModelResponse);
    }

}