package com.socialhub.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.socialhub.entity.User;
import com.socialhub.dto.UserCredentials;
import com.socialhub.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Check if username/email already exists in the database
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new RuntimeException("Username already exists");
        } 

        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists");
        }

        // Save the user to the database
        return userRepository.save(user);
    }

    public User loginUser(UserCredentials credentials) {
        // Perform login logic (e.g., validation, authentication)
        String username = credentials.getUsername();
        String password = credentials.getPassword();

        // Check if username/email and password are provided
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Username/email and password are required");
        }

        // Check if user exists with the given username/email and password
        User user = userRepository.findByUsernameAndPassword(username, password);
        if (user == null) {
            // Authentication failed
            // You can throw an exception or return null depending on your application's requirements
            throw new RuntimeException("Invalid username/email or password");
        }

        // Authentication successful, return user details
        return user;
    }
    
}
