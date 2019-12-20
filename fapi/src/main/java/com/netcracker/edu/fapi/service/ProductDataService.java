package com.netcracker.edu.fapi.service;

import com.netcracker.edu.fapi.models.ProductViewModel;
import com.netcracker.edu.fapi.models.SaveProductViewModel;

public interface ProductDataService {

    void saveNewProduct(SaveProductViewModel prod);
    void deleteProduct(Integer id);
    void changeStatusProduct(Integer id);
    ProductViewModel getProductById(Integer id);
    Integer getAdvertiserByProductId(Integer id);


}
