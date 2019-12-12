package com.netcracker.edu.fapi.converter;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.CatalogItemDataService;
import com.netcracker.edu.fapi.service.ProductDataService;
import com.netcracker.edu.fapi.service.StatusProductDataService;
import com.netcracker.edu.fapi.service.SubscriptionDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductAdminConverter {

    @Autowired
    private CatalogItemDataService productDataService;

    @Autowired
    private ProductDataService productService;

    @Autowired
    private StatusProductDataService statusProductDataService;

    @Autowired
    private SubscriptionDataService subscriptionDataService;

    @RequestMapping("/api/product/byNameAsc")
    @GetMapping
    public ResponseEntity<List<ProductAdminViewModel>> productAdminByNameAsc() {
        List<ProductViewModel> catalogItem = productDataService.getAllByNameAsc();
        List<StatusProductViewModel> status = statusProductDataService.getAll();
        List<ProductAdminViewModel> convertProductViewModels = fillConvertModel(catalogItem, status);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }

    @RequestMapping("/api/product/new/product")
    @GetMapping
    public ResponseEntity<List<ProductAdminViewModel>> productAdminNew() {
        List<ProductViewModel> catalogItem = productDataService.getAllByStatusId();
        List<StatusProductViewModel> status = statusProductDataService.getAll();
        List<ProductAdminViewModel> convertProductViewModels = fillConvertModel(catalogItem, status);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }

    @RequestMapping(value = "/api/product/delete/{id}", method = RequestMethod.DELETE)
    public void deleteProduct(@PathVariable String id) {
        List<SubscriptionViewModel> subs = subscriptionDataService.getSubscriptionByProductId(Integer.valueOf(id));
        if(subs.size() == 0) {
            productService.deleteProduct(Integer.valueOf(id));
        }else{
            productService.changeStatusProduct(Integer.valueOf(id));
        }
    }

    @RequestMapping(value = "/api/product/new/confirm/", method = RequestMethod.POST)
    public void confirmNewProduct(@RequestBody Integer id) {
        productDataService.confirmNewProduct(id);
    }

    @RequestMapping(value = "/api/product/new/delete/{id}", method = RequestMethod.DELETE)
    public void deleteNewProduct(@PathVariable String id) {
            productService.deleteProduct(Integer.valueOf(id));
    }

    public List<ProductAdminViewModel> fillConvertModel(List<ProductViewModel> catalogItem, List<StatusProductViewModel> status) {
        List<ProductAdminViewModel> productAdminViewModels = new ArrayList<>();
        for (ProductViewModel item : catalogItem) {
            ProductAdminViewModel a = new ProductAdminViewModel();
            a.setId(item.getId());
            a.setName(item.getName());
            a.setCost(item.getCost());
            a.setDescription(item.getDescription());
            a.setSubscriptionCount(item.getSubscriptionCount());
            for (StatusProductViewModel statusProd : status) {
                if (item.getStatusProductId() == statusProd.getId()) {
                    a.setStatus(statusProd.getName());
                }
            }
            productAdminViewModels.add(a);
        }
        return productAdminViewModels;
    }
}

