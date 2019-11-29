package com.netcracker.edu.fapi.converter;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.CatalogItemDataService;
import com.netcracker.edu.fapi.service.CategoryDataService;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
@RequestMapping("/api/customerSubscription")
@RestController
public class SubscriptionConverter {

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @Autowired
    private CatalogItemDataService productDataService;

    @Autowired
    private  CategoryDataService categoryDataService;

    @GetMapping
    @RequestMapping(value = "/{id}")
    public ResponseEntity<List<ConvertSubscriptionViewModel>> convertCategoryToProductByNameAsc(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
            List<SubscriptionViewModel> subs = subscriptionDataService.getSubscriptionByUserId(userId);
        List<ProductViewModel> catalogItem = productDataService.getAllByNameAsc();
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertSubscriptionViewModel> convertSubscription = fillConvertModel(catalogItem,category,subs);
        return ResponseEntity.ok(convertSubscription == null ? Collections.emptyList() : convertSubscription);
    }

    public List<ConvertSubscriptionViewModel> fillConvertModel(List<ProductViewModel> catalogItem,List<CategoryViewModel> category,List<SubscriptionViewModel> subs){
        List<ConvertSubscriptionViewModel> convertSubscription = new ArrayList<>();
        for (SubscriptionViewModel item: subs) {
            ConvertSubscriptionViewModel a = new ConvertSubscriptionViewModel();
            a.setId(item.getId());
            for (ProductViewModel prod: catalogItem) {
                if (item.getProductId() == prod.getId()) {
                    a.setName(prod.getName());
                    a.setCost(prod.getCost());
                    for(CategoryViewModel cat : category){
                        if(prod.getCategoryId() == cat.getId()){
                            a.setCategory(cat.getName());
                        }
                    }
                }
            }
            convertSubscription.add(a);
        }
        return convertSubscription;
    }
}





