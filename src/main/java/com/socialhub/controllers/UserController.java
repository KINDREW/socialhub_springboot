package com.socialhub.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.socialhub.dto.UserCredentials;
import com.socialhub.entity.User;
import com.socialhub.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public User loginUser(@RequestBody UserCredentials credentials) {
        return userService.loginUser(credentials);
    }
}
