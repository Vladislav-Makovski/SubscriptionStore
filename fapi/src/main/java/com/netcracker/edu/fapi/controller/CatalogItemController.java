package com.netcracker.edu.fapi.controller;
import com.netcracker.edu.fapi.models.ProductViewModel;
import com.netcracker.edu.fapi.service.CatalogItemDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/ba")
public class CatalogItemController {

    @Autowired
    private CatalogItemDataService productDataService;

    @RequestMapping
    public ResponseEntity<List<ProductViewModel>> getAllProductAccounts() {
        return ResponseEntity.ok(productDataService.getAll());
    }

//    @RequestMapping
//    public List<ProductViewModel> getAllProductAccounts() {
//        List<ProductViewModel> product = new ArrayList<>();
//        ProductViewModel a = new ProductViewModel();
//        a.setId(1);
//        a.setName("Yandex music");
//        a.setDescription("Яндекс.Музыка» — стриминговый сервис компании «Яндекс», позволяющий прослушивать музыкальные композиции, альбомы, подборки музыкальных треков и получать персональные рекомендации.");
//        a.setCategory("Music");
//        a.setCost(2);
//        product.add(a);
//        ProductViewModel b = new ProductViewModel();
//        b.setId(2);
//        b.setName("Apple music");
//        b.setDescription("Apple Music — музыкальная служба предоставляющий доступ к миллионам композиций из библиотеки iTunes Store");
//        b.setCategory("Music");
//        b.setCost(3);
//        ProductViewModel c = new ProductViewModel();
//        c.setId(3);
//        c.setName("NETFLIX");
//        c.setDescription("NETFLIX - стриминговый сервис с фильмами и сериалами");
//        c.setCategory("Films");
//        c.setCost(10);
//        product.add(c);
//        return product;
//    }
}
