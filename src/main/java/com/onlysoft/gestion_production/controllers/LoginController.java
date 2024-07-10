package com.onlysoft.gestion_production.controllers;

import com.onlysoft.gestion_production.dto.LoginRequest;
import com.onlysoft.gestion_production.dto.LoginResponse;
import com.onlysoft.gestion_production.services.jwt.UserServiceImpl;
import com.onlysoft.gestion_production.utils.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin(origins = "http://localhost:4200")

public class LoginController {
    private final AuthenticationManager authenticationManager;

    private final UserServiceImpl userService;

    private final JwtUtil jwtUtil;

    @Autowired
    public LoginController(AuthenticationManager authenticationManager, UserServiceImpl userService, JwtUtil jwtUtil) {
        this.authenticationManager = authenticationManager;
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );

        } catch (AuthenticationException e) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }

        UserDetails userDetails;

        try{
            userDetails = userService.loadUserByUsername(loginRequest.getEmail());
        } catch (UsernameNotFoundException e ) {

             return  ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
 String jwt = jwtUtil.generateToken(userDetails.getUsername());

        //Aditional logic can be added here if needed


        return ResponseEntity.ok(new LoginResponse(jwt));

    }
}
