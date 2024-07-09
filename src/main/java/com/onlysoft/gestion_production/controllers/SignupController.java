package com.onlysoft.gestion_production.controllers;

import com.onlysoft.gestion_production.dto.SignupRequest;
import com.onlysoft.gestion_production.entities.User;
import com.onlysoft.gestion_production.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/signup")
public class SignupController {
    private final AuthService authService;

    @Autowired
    public SignupController(AuthService authService) {
        this.authService = authService;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping
    public ResponseEntity<Map<String, String>> signup(@RequestBody User user) {
        // logique d'inscription
        Map<String, String> response = new HashMap<>();
        response.put("message", "User created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
