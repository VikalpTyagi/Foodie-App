package com.niit.ResturantAuthService.security;



import com.niit.ResturantAuthService.domain.Restaurant;

import java.util.Map;

public interface SecurityTokenGenerator {
    Map<String,String> generateToken(Restaurant restaurant);
}
