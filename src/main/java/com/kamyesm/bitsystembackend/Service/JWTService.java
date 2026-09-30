package com.kamyesm.bitsystembackend.Service;

import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;

public interface JWTService {
    String generateToken(UserDetails userDetails, String role);
    Claims extractAllClaims(String token);
    String extractUsername(String token);
    public String extractRole(String token);
    boolean isTokenValid(String token, UserDetails userDetails);
    boolean isTokenExpired(String token);
}
