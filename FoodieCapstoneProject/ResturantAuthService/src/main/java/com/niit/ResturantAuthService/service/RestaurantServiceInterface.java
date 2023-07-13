package com.niit.ResturantAuthService.service;

import com.niit.ResturantAuthService.domain.Cuisines;
import com.niit.ResturantAuthService.domain.Restaurant;
import com.niit.ResturantAuthService.exception.InvalidCredentialsException;
import com.niit.ResturantAuthService.exception.RestaurantAlreadyExistException;

import java.util.List;
import java.util.Set;

public interface RestaurantServiceInterface {
    Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException;
    Restaurant loginRestaurant(String restaurantId,String password) throws InvalidCredentialsException;
    Restaurant saveCuisines(Cuisines cuisines, String id);
    List<Restaurant> getDetails();
    Restaurant getRestaurantById(String id);
    List<Restaurant> basedOnLocation(String location);
    List<Restaurant> basedOnName(String restaurantName);

    List<Cuisines> deleteDish(String id, String foodName);

    Set<String> citiesName();
}
