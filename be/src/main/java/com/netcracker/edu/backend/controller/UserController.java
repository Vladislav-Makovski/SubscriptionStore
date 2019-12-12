package com.netcracker.edu.backend.controller;

import com.netcracker.edu.backend.entity.UserDetails;
import com.netcracker.edu.backend.service.UserDetailsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserDetailsService userService;

    @RequestMapping(value = "/login/{login}", method = RequestMethod.GET)
    public ResponseEntity<UserDetails> getUserByLogin(@PathVariable(name = "login") String login) {
        UserDetails user = userService.findByUsername(login);
        return ResponseEntity.ok(user);
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public List<UserDetails> getAllUsers() {
        return userService.findAll();
    }
}
