package com.netcracker.edu.fapi.service.impl;

import com.netcracker.edu.fapi.models.CategoryViewModel;
import com.netcracker.edu.fapi.models.StatusProductViewModel;
import com.netcracker.edu.fapi.service.StatusProductDataService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class StatusProductDataServiceImpl implements StatusProductDataService {

    @Value("${backend.server.url}")
    private String backendServerUrl;

    @Override
    public List<StatusProductViewModel> getAll() {
        RestTemplate restTemplate = new RestTemplate();
        StatusProductViewModel[] statusProductViewModels = restTemplate.getForObject(backendServerUrl + "/api/statusProduct/all", StatusProductViewModel[].class);
        return statusProductViewModels == null ? Collections.emptyList() : Arrays.asList(statusProductViewModels);
    }

}
