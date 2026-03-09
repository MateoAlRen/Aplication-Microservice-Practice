package com.employabilityassesment.practice.infrastructure.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.UUID;

@Service
public class JwtService {
    @Value("¨${jwt.secret}")
    private String jwtSecret;

    private Key getSignInKey(){
        return Keys.hmacShaKeyFor(jwtSecret.getBytes());
    }

    public String generateToken(UUID userId){
        return Jwts.builder()
                .setSubject(userId.toString())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 600000))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    public UUID getCurrentUser(String token){
        return UUID.fromString(
                Jwts.parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject()
        );
    }
}
