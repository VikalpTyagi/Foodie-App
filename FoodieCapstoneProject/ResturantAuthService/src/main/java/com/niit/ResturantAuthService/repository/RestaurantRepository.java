package com.niit.ResturantAuthService.repository;

import com.niit.ResturantAuthService.domain.Restaurant;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RestaurantRepository extends MongoRepository<Restaurant,String> {
    Restaurant findByRestaurantIdAndPassword(String restaurantId,String password);
    List<Restaurant> findByLocation(String location);
    List<Restaurant> findByRestaurantName(String restaurantName);
}
