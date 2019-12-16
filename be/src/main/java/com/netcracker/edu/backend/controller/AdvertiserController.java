package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.Organization;
import com.netcracker.edu.backend.entity.Product;
import com.netcracker.edu.backend.service.AdvertiserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteAdvertiserById(@PathVariable(name = "id") Integer id) {
        advertiserService.deleteAdvertiserById(id);
    }

    @GetMapping
    @RequestMapping(value = "information/{id}", method = RequestMethod.GET)
    public Optional<Organization> getAdvertiserById(@PathVariable(name = "id") Integer id) {
        return advertiserService.getAdvertiserById(id);
    }

    @GetMapping
    @RequestMapping(value = "information/userDetails/{id}", method = RequestMethod.GET)
    public Optional<Organization> getAdvertiserByUserDetailsId(@PathVariable(name = "id") Integer id) {
        return advertiserService.getAdvertiserByUserDetailsId(id);
    }
}
