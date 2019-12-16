package com.netcracker.edu.backend.service.impl;

import com.netcracker.edu.backend.entity.UserDetails;
import com.netcracker.edu.backend.entity.Wallet;
import com.netcracker.edu.backend.repository.SubscriptionRepository;
import com.netcracker.edu.backend.repository.UserDetailsRepository;
import com.netcracker.edu.backend.service.UserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

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

    @Override
    public Optional<UserDetails> getUserDetailsById(Integer id){
        return userDetailsRepository.findById(id);
    }

    @Override
    public void deleteUserDetailsById(Integer id) {
        userDetailsRepository.deleteById(id);
    }

    @Override
    public List<UserDetails> findAll() {
        return (List<UserDetails>) userDetailsRepository.findAll();
    }

    @Override
    public UserDetails findByUsername(String login) {
        return userDetailsRepository.findByUsername(login);
    }

}
