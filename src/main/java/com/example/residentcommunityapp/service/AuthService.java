package com.example.residentcommunityapp.service;

import com.example.residentcommunityapp.model.User;
import com.example.residentcommunityapp.repository.UserRepository;
import com.example.residentcommunityapp.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class AuthService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private JwtUtil jwtUtil;

    private final Map<String, String> otpStorage = new HashMap<>();

    public String generateOtp(String identifier) {
        String otp = String.valueOf(new Random().nextInt(900000) + 100000); // 6-digit OTP
        otpStorage.put(identifier, otp);

        // Log OTP (simulate SMS/email)
        System.out.println("Generated OTP for " + identifier + ": " + otp);
        return otp;
    }

    public boolean verifyOtp(String identifier, String otp) {
        return otp.equals(otpStorage.get(identifier));
    }

    public String authenticateUser(String identifier) {
        User user = userRepository.findByMobileOrEmail(identifier, identifier)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));

        // Generate JWT after successful OTP verification
        return jwtUtil.generateToken(user);
    }
}
