package com.niit.project.FavouriteService.service;

import com.niit.project.FavouriteService.domain.Restaurant;
import com.niit.project.FavouriteService.domain.User;
import com.niit.project.FavouriteService.exception.RestaurantAlreadyExist;
import com.niit.project.FavouriteService.exception.RestaurantNotFound;
import com.niit.project.FavouriteService.exception.UserNotFound;

import java.util.List;

public interface FavouriteService {

    User addRestaurantToFavourite(Restaurant restaurant, String email) throws UserNotFound, RestaurantAlreadyExist;

    User deleteFavourite(String id, String email) throws UserNotFound, RestaurantNotFound;

    List<Restaurant> getAllFavourites(String email) throws RestaurantNotFound;



}
