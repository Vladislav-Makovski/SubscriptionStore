package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserDetails;
import com.netcracker.edu.backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/new/")
public class UserDetailsController {

    private UserDetailsService userDetailsService;

    @Autowired
    public UserDetailsController(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @RequestMapping(value = "customer/userDetails",method = RequestMethod.POST)
    public UserDetails saveUserDetails(@RequestBody UserDetails userDetails) {
        return userDetailsService.saveUserDetails(userDetails);
    }

    @RequestMapping(value = "advertiser/userDetails",method = RequestMethod.POST)
    public UserDetails saveAdvertiserDetails(@RequestBody UserDetails userDetails) {
        return userDetailsService.saveUserDetails(userDetails);
    }

}
