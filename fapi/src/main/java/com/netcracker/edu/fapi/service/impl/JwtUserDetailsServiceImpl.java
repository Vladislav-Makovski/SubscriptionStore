//package com.netcracker.edu.fapi.service.impl;
//
//import com.netcracker.edu.fapi.models.User;
//import com.netcracker.edu.fapi.service.JwtUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.util.*;
//
//@Service("jwtUserDetailsService")
//public class JwtUserDetailsServiceImpl implements JwtUserDetailsService {
//
//    @Value("${backend.server.url}")
//    private String backendServerUrl;
//
//    @Autowired
//    private BCryptPasswordEncoder bCryptPasswordEncoder;
//
//    @Override
//    public User findByUsername(String login) {
//        RestTemplate restTemplate = new RestTemplate();
//        User user = restTemplate.getForObject(backendServerUrl + "/api/user/login/" + login, User.class);
//        return user;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("Invalid username or password.");
//        }
//        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getAuthority(user));
//    }
//
//    private Set<SimpleGrantedAuthority> getAuthority(User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
//        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole()));
//        return authorities;
//    }
//}
