package com.onlysoft.gestion_production.services;

import com.onlysoft.gestion_production.dto.SignupRequest;
import com.onlysoft.gestion_production.entities.User;

public interface AuthService {
    User createUser(SignupRequest signupRequest);
}
