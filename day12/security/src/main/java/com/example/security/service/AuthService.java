package com.example.security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.security.dto.AuthRequest;
import com.example.security.dto.AuthResponse;
import com.example.security.model.User;
import com.example.security.repository.UserRepository;
import com.example.security.util.JwtUtil;

@Service
public class AuthService {

    @Autowired private UserRepository repo;
    @Autowired private PasswordEncoder encoder;
    @Autowired private JwtUtil jwtUtil;

    public String register(AuthRequest request) {
        if (repo.findByUsername(request.getUsername()).isPresent())
            throw new RuntimeException("User already exists");

        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(encoder.encode(request.getPassword()));
        user.setRoles(List.of("ROLE_USER"));
        repo.save(user);
        return "User registered successfully!";
    }

    public AuthResponse login(AuthRequest request) {
        User user = repo.findByUsername(request.getUsername())
                        .orElseThrow(() -> new RuntimeException("Invalid username"));

        if (!encoder.matches(request.getPassword(), user.getPassword()))
            throw new RuntimeException("Invalid password");

        String token = jwtUtil.generateToken(user);
        return new AuthResponse(token);
    }
}
