package com.kamyesm.bitsystembackend.Service.Implemention;

import com.kamyesm.bitsystembackend.Service.JWTService;
import com.kamyesm.bitsystembackend.Utils.RsaKeyProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTServiceImp implements JWTService {

    private final RsaKeyProperties rsaKeys;
    private final long JWT_EXPIRATION = 86400000;

    public JWTServiceImp(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }

    public String generateToken(UserDetails userDetails, String role) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("role", role)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                .signWith(rsaKeys.getPrivateKey(), Jwts.SIG.RS256)
                .compact();
    }

    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                .verifyWith(rsaKeys.getPublicKey())
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("role", String.class);
    }

    public boolean isTokenValid(String token, UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }

    public boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}