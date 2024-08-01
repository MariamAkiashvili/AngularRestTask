package com.epam.upskill.calculator.jwt;

import io.jsonwebtoken.*;

import java.util.Date;

public class JwtUtil {

    private final static String SECRET_KEY = "Spring_Boot_Secret_Key";

    public static String generateToken(String username){
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
                .signWith(SignatureAlgorithm.ES512, SECRET_KEY)
                .compact();

    }

    public boolean validateToken(String token) {
        Jws<Claims> claims = Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token);
        return !claims.getBody().getExpiration().before(new Date());
    }
}
