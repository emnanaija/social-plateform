package com.example.plateforme.services;

import com.example.plateforme.DTO.LoginRequest;
import com.example.plateforme.DTO.RegisterRequest;
import com.example.plateforme.Utils.JwtUtil;
import com.example.plateforme.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.example.plateforme.entites.User;

import java.util.ArrayList;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtUtil jwtUtil;

    @Autowired
    private AuthenticationManager authenticationManager;

    public void register(RegisterRequest request) {
        User user = new User();
        user.setUsername(request.username);
        user.setEmail(request.email);
        user.setPassword(passwordEncoder.encode(request.password));
        userRepository.save(user);
    }

    public String login(LoginRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.email, request.password)
        );

        UserDetails userDetails = userRepository.findByEmail(request.email)
                .map(u -> new org.springframework.security.core.userdetails.User(
                        u.getEmail(), u.getPassword(), new ArrayList<>()))
                .orElseThrow();

        return jwtUtil.generateToken(userDetails);
    }
}
