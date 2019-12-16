package com.netcracker.edu.backend.service;

import com.netcracker.edu.backend.entity.UserDetails;

import java.util.List;
import java.util.Optional;

public interface UserDetailsService {

    UserDetails saveUserDetails(UserDetails user);
    Optional<UserDetails> getUserDetailsById(Integer id);
    void deleteUserDetailsById(Integer id);
    List<UserDetails> findAll();
    UserDetails findByUsername(String login);
}
