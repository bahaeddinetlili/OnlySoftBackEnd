package com.onlysoft.gestion_production.services;

import com.onlysoft.gestion_production.dto.SignupRequest;

public interface AuthService {
    boolean createUser(SignupRequest signupRequest);
}
