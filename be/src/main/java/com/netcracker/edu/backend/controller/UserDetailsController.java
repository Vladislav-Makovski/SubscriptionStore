package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserDetails;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

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

    @GetMapping
    @RequestMapping(value = "customer/userDetails/{id}", method = RequestMethod.GET)
    public Optional<UserDetails> getUserDetailsById(@PathVariable(name = "id") Integer id) {
        return userDetailsService.getUserDetailsById(id);
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.DELETE)
    public void deleteUserDetailsById(@PathVariable(name = "id") Integer id) {
        userDetailsService.deleteUserDetailsById(id);
    }

}
