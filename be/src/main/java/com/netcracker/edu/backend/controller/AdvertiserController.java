package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/new/advertiser/")
public class AdvertiserController {

    private AdvertiserService advertiserService;

    @Autowired
    public AdvertiserController(AdvertiserService advertiserService) {
        this.advertiserService = advertiserService;
    }

    @RequestMapping(value = "create",method = RequestMethod.POST)
    public Organization saveAdvertiser(@RequestBody Organization advertiser) {
        return advertiserService.saveAdvertiser(advertiser);
    }
}
