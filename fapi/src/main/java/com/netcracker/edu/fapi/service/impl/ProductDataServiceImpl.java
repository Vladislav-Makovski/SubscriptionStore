package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.ProductViewModel;
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

    @Override
    public void deleteProduct(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(backendServerUrl + "/api/product/delete/" + id);
    }

    @Override
    public void changeStatusProduct(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        SaveProductViewModel save = new SaveProductViewModel();
        save.setId(id);
        restTemplate.postForEntity(backendServerUrl + "/api/product/changeStatus/pause",save, SaveProductViewModel.class);
    }

    @Override
    public ProductViewModel getProductById(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/product/custom/" + id, ProductViewModel.class);
    }

    @Override
    public Integer getAdvertiserByProductId(Integer id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(backendServerUrl + "/api/product/adverId/" + id, Integer.class);
    }
}
