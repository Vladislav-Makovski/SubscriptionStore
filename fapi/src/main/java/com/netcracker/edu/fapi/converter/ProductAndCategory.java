package com.netcracker.edu.fapi.converter;

import com.netcracker.edu.fapi.models.*;
import com.netcracker.edu.fapi.service.CatalogItemDataService;
import com.netcracker.edu.fapi.service.CategoryDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
public class ProductAndCategory {

    @Autowired
    private CatalogItemDataService productDataService;

    @Autowired
    private CategoryDataService categoryDataService;

    @RequestMapping("/api/NameAsc")
    @GetMapping
    public ResponseEntity<List<ConvertProductViewModel>> convertCategoryToProductByNameAsc() {
        List<ProductViewModel> catalogItem = productDataService.getAllByNameAsc();
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertProductViewModel> convertProductViewModels = fillConvertModel(catalogItem,category);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }

    @RequestMapping("/api/NameDesc")
    @GetMapping
    public ResponseEntity<List<ConvertProductViewModel>> convertCategoryToProductByNameDesc() {
        List<ProductViewModel> catalogItem = productDataService.getAllByNameDesc();
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertProductViewModel> convertProductViewModels = fillConvertModel(catalogItem,category);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }

    @RequestMapping("/api/CategoryAsc")
    @GetMapping
    public ResponseEntity<List<ConvertProductViewModel>> convertCategoryToProductByCategoryAsc() {
        List<ProductViewModel> catalogItem = productDataService.getAllByCategoryIdAsc();
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertProductViewModel> convertProductViewModels = fillConvertModel(catalogItem,category);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }

    @RequestMapping("/api/CategoryDesc")
    @GetMapping
    public ResponseEntity<List<ConvertProductViewModel>> convertCategoryToProductByCategoryDesc() {
        List<ProductViewModel> catalogItem = productDataService.getAllByCategoryIdDesc();
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertProductViewModel> convertProductViewModels = fillConvertModel(catalogItem,category);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }


    @RequestMapping("/api/PriceAsc")
    @GetMapping
    public ResponseEntity<List<ConvertProductViewModel>> convertCategoryToProductByPriceAsc() {
        List<ProductViewModel> catalogItem = productDataService.getAllByPriceAsc();
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertProductViewModel> convertProductViewModels = fillConvertModel(catalogItem,category);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }

    @RequestMapping("/api/PriceDesc")
    @GetMapping
    public ResponseEntity<List<ConvertProductViewModel>> convertCategoryToProductByPriceDesc() {
        List<ProductViewModel> catalogItem = productDataService.getAllByPriceDesc();
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertProductViewModel> convertProductViewModels = fillConvertModel(catalogItem,category);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() : convertProductViewModels);
    }

    @RequestMapping("/api/advertiser/product/{id}")
    @GetMapping
    public ResponseEntity<List<ConvertProductViewModel>> getAdvertiserProduct(@PathVariable String id) {
        Integer userId = Integer.valueOf(id);
        List<ProductViewModel> catalogItem = productDataService.getProductByAdvertiserId(userId);
        List<CategoryViewModel> category = categoryDataService.getAll();
        List<ConvertProductViewModel> convertProductViewModels = fillConvertModel(catalogItem,category);
        return ResponseEntity.ok(convertProductViewModels == null ? Collections.emptyList() :convertProductViewModels);
    }

    public List<ConvertProductViewModel> fillConvertModel(List<ProductViewModel> catalogItem,List<CategoryViewModel> category){
        List<ConvertProductViewModel> convertProductViewModels = new ArrayList<>();
        for (ProductViewModel item: catalogItem  ) {
            if (item.getStatusProductId() == 1) {
                ConvertProductViewModel a = new ConvertProductViewModel();
                a.setId(item.getId());
                a.setName(item.getName());
                a.setDescription(item.getDescription());
                a.setCost(item.getCost());
                a.setSubscriptionCount(item.getSubscriptionCount());
                for (CategoryViewModel cat : category) {
                    if (item.getCategoryId() == cat.getId()) {
                        a.setCategory(cat.getName());
                    }
                }
                convertProductViewModels.add(a);
            }
        }
        return convertProductViewModels;
    }
}
