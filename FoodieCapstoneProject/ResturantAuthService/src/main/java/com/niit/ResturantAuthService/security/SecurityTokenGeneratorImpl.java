package com.niit.ResturantAuthService.security;



import com.niit.ResturantAuthService.domain.Restaurant;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Service
public class SecurityTokenGeneratorImpl implements SecurityTokenGenerator{
    @Override
    public Map<String, String> generateToken(Restaurant restaurant) {
        String jwtToken =  Jwts.builder()
                .setSubject(restaurant.getRestaurantId())
                .setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256,"secretKey").compact();
        Map<String,String> map = new HashMap<>();
        map.put("token",jwtToken);
        map.put("message","Authentication Successful");
        return map;
    }
}
