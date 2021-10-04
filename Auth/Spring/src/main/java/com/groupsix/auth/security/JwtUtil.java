package com.groupsix.auth.security;

import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

public class JwtUtil {
    public static String generateToken(String signingKey, String subject){
        Date now = new Date(System.currentTimeMillis());

        JwtBuilder builder = Jwts.builder().setSubject(subject).setIssuedAt(now).signWith(SignatureAlgorithm.HS256, signingKey);
        return builder.compact();
    }
}
