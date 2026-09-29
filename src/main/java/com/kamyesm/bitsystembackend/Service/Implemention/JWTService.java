package com.kamyesm.bitsystembackend.Service.Implemention;

import com.kamyesm.bitsystembackend.Utils.RsaKeyProperties;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JWTService {

    private final RsaKeyProperties rsaKeys;
    private final long JWT_EXPIRATION = 86400000; // 24 ساعت به میلی‌ثانیه

    public JWTService(RsaKeyProperties rsaKeys) {
        this.rsaKeys = rsaKeys;
    }

    // ۱. صدور توکن (با کلید خصوصی امضا می‌شود)
    public String generateToken(UserDetails userDetails, String role) {
        return Jwts.builder()
                .subject(userDetails.getUsername())
                .claim("role", role) // قرار دادن رول داخل توکن
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + JWT_EXPIRATION))
                // استفاده از الگوریتم نامتقارن RS256 و کلید خصوصی
                .signWith(rsaKeys.getPrivateKey(), Jwts.SIG.RS256)
                .compact();
    }

    // ۲. استخراج اطلاعات از توکن (با کلید عمومی بازگشایی می‌شود)
    public Claims extractAllClaims(String token) {
        return Jwts.parser()
                // فقط کلید عمومی را به متد verify می‌دهیم!
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

    private boolean isTokenExpired(String token) {
        return extractAllClaims(token).getExpiration().before(new Date());
    }
}