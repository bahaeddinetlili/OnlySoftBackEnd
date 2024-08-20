package com.onlysoft.gestion_production.services;

import com.onlysoft.gestion_production.dto.SignupRequest;
import com.onlysoft.gestion_production.entities.User;
import com.onlysoft.gestion_production.repository.UserRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public AuthServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User createUser(SignupRequest signupRequest) {
        // check if user already exist
        if(userRepository.existsByEmail(signupRequest.getEmail())) {
            return  null;
        }
        User user = new User();
        BeanUtils.copyProperties(signupRequest,user);
        /*
        beanUtils remplace tout ca

        user.setEmail(signupRequest.getEmail());
        user.setName(signupRequest.setName());
        */

        //Hash the password before saving
        String hashPassword = passwordEncoder.encode(signupRequest.getPassword());
        user.setPassword(hashPassword);
        userRepository.save(user);

        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll().stream()
                .peek(user -> user.setPassword(user.getPassword())) // Avoid encoding
                .collect(Collectors.toList());
    }


}
