package com.takeo.bookmanagementsystem.controller;

import com.takeo.bookmanagementsystem.model.User;
import com.takeo.bookmanagementsystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserRepository userRepository;

    @Autowired
    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /*
    {
    "username": "onsever",
    "password": "123456"

    user.getUsername() -> "onsever"
}
     */

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        // Find the user
        User existingUser = userRepository.findUserByUsername(user.getUsername()).orElse(null);

        if (existingUser == null) {
            return ResponseEntity.notFound().build();
        }

        if (existingUser.getPassword().equals(user.getPassword()) && existingUser.getUsername().equals(user.getUsername())) {
            return ResponseEntity.ok(existingUser);
        }

        return ResponseEntity.notFound().build();
    }

    @PostMapping("/register")
    public ResponseEntity<User> register(@RequestBody User user) {
        // Check if the user exists or not. (We can't use ID to check because this is the first time happening)
        // If username is not available in the database, it will be null. -> User doesn't exists.
        User existingUser = userRepository.findUserByUsername(user.getUsername()).orElse(null);

        if (existingUser == null) {
            // User doesn't exist, create a new user
            User newUser = new User();
            newUser.setUsername(user.getUsername());
            newUser.setPassword(user.getPassword());

            userRepository.save(newUser);

            return ResponseEntity.ok(newUser);
        }

        return ResponseEntity.badRequest().build();
    }
}
