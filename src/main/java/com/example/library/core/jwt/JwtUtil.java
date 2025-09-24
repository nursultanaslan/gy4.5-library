package com.example.library.core.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;

@Service
public class JwtUtil {

    private final String SECRET_KEY = "956b2c913e70678e200ddb671f1132288b51061dfdd71fd2c4e5b4ded697086d8d7fd2436ea30aba8affd05b1c443cbd5ce6eb235f9fe7197656b0a337ddf15b";

    //Jwt'yi üretecek kod
    public String generateToken(String username){
        Date expirationDate = new Date(System.currentTimeMillis() + 1000*60*60);
        //claims() : jwt'nin payload kısmına ekleyecegimiz extra bilgiler.
        HashMap<String, Object> claims = new HashMap<>();
        claims.put("username", username);
        claims.put("admin", true);

        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
        String jwt = Jwts
                .builder()
                .subject(username)
                .issuedAt(new Date(System.currentTimeMillis()))
                .expiration(expirationDate)
                .claims(claims)
                .signWith(secretKey)
                .compact();

        return jwt;
    }

    public Boolean validateToken(String token){
        try
        {
            Claims claims = extractAllClaims(token); //tokenin içinden bütün claimleri alırım once
            return claims.getExpiration().after(new Date());  //süresinin dolma tarihi simdiden sonraki bir deger olmasını bekler
        }
        catch (Exception e)
        {
            return false;
        }
    }

    private Claims extractAllClaims(String token){
        SecretKey secretKey = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

        return Jwts
                .parser()
                .verifyWith(secretKey)
                .build()
                .parseSignedClaims(token)  //tokenin imzalanmış claimlerini al
                .getPayload();             //payload kısmını bana ver
    }

    public String extractUsername(String token){
        Claims claims = extractAllClaims(token);
        return claims.getSubject();
    }
}
