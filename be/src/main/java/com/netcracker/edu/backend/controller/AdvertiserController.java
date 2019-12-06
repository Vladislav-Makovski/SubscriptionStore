package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/advertiser/")
public class AdvertiserController {

    private AdvertiserService advertiserService;

    @Autowired
    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @RequestMapping(value = "new/create",method = RequestMethod.POST)
    public Organization saveAdvertiser(@RequestBody Organization advertiser) {
        return advertiserService.saveAdvertiser(advertiser);
    }

    @RequestMapping("nameAsc")
    @GetMapping
    public Iterable<Organization> getAllOrganizationByNameAsc()
    {
        return advertiserService.getAllOrganizationByNameAsc();
    }
}
