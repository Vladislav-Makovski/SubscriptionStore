package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UserDetails;
import com.netcracker.edu.backend.repository.SubscriptionRepository;
import com.netcracker.edu.backend.repository.UserDetailsRepository;
import com.netcracker.edu.backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserDetailsServiceImpl(UserDetailsRepository repository) {
        this.userDetailsRepository = repository;
    }

    @Override
    public UserDetails saveUserDetails(UserDetails user) {
        return userDetailsRepository.save(user);
    }
}
