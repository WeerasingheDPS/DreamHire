package com.dreamhire.DreamHire.service;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String generateToken(String email);

    boolean validateToken(String token, UserDetails userDetails);

    String extractUsername(String token);
}
