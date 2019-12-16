package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserDetails;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserSignatureController {

    private UserDetailsService userDetailsService;

    @Autowired
    public UserSignatureController (UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @GetMapping
    @RequestMapping(value = "/api/user/signature/{username}", method = RequestMethod.GET)
    public UserDetails getWalletById(@PathVariable(name = "username") String username) {
        return userDetailsService.findByUsername(username);
    }


}
