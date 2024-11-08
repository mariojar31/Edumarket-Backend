package com.edumarket.backend.config;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import jakarta.annotation.PostConstruct;



@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String secretKey;

    private byte[] secretKeyBytes;
    private String secretKeyB64;

    // Método que se ejecuta después de la inyección de la propiedad
    @PostConstruct
    public void init() {
        // Inicializa las variables después de la inyección de la propiedad
        secretKeyBytes = secretKey.getBytes(StandardCharsets.UTF_8);
        secretKeyB64 = Base64.getUrlEncoder().withoutPadding().encodeToString(secretKeyBytes);
    }

    public String generateToken(String email) {
        return Jwts.builder()
                .subject(email)  
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) 
                .signWith(Keys.hmacShaKeyFor(secretKeyB64.getBytes()))
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    private <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {
        return Jwts.parser().verifyWith(Keys.hmacShaKeyFor(secretKeyB64.getBytes())).build().parseSignedClaims(token).getPayload();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    private Date extractExpiration(String token) {
        return extractClaim(token, Claims::getExpiration);
    }
}

