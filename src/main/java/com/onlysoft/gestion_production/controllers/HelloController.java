package com.onlysoft.gestion_production.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HelloController {

    @GetMapping(value = "/hello", produces = "application/json")
    public ResponseEntity<String> hello() {
        return ResponseEntity.ok("{\"message\":\"Hello from authorized API request !\"}");
    }
}
