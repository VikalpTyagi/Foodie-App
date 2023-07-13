package com.niit.ResturantAuthService.service;

import com.niit.ResturantAuthService.domain.Cuisines;
import com.niit.ResturantAuthService.domain.Restaurant;
import com.niit.ResturantAuthService.repository.RestaurantRepository;
import com.niit.ResturantAuthService.exception.InvalidCredentialsException;
import com.niit.ResturantAuthService.exception.RestaurantAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class RestaurantServiceImpl implements RestaurantServiceInterface {
    private RestaurantRepository restaurantRepository;

    @Autowired
    RestaurantServiceImpl( RestaurantRepository restaurantRepository ){
        this.restaurantRepository=restaurantRepository;
    }

    @Override
    public Restaurant saveRestaurant(Restaurant restaurant) throws RestaurantAlreadyExistException{
        if (restaurantRepository.findById(restaurant.getRestaurantId()).isPresent()){
            throw new RestaurantAlreadyExistException();
        }
//        restaurant.deleteDish();
        return restaurantRepository.save(restaurant);
    }

    @Override
    public Restaurant loginRestaurant(String restaurantId, String password) throws InvalidCredentialsException {
        Restaurant checkUser=restaurantRepository.findByRestaurantIdAndPassword(restaurantId,password);
        if(checkUser==null){
            throw new InvalidCredentialsException();
        }
        return checkUser;
    }

    @Override
    public List<Restaurant> getDetails() {
        return restaurantRepository.findAll();
    }

    @Override
    public Restaurant getRestaurantById(String id){
        return restaurantRepository.findById(id).get();
    }

    @Override
    public Restaurant saveCuisines(Cuisines cuisines, String id){
    Optional<Restaurant> findRestaurant= restaurantRepository.findById(id);
        if (findRestaurant.isEmpty()) {
        return null;
        }
    Restaurant existRestaurant=findRestaurant.get();
    if (cuisines !=null) {
        if (existRestaurant.getDishes() == null) {
            List<Cuisines> listOfDish = new ArrayList<>();
            listOfDish.add(cuisines);
            existRestaurant.setDishes(listOfDish);
        } else {
            existRestaurant.addDish(cuisines);
        }
    }
    return restaurantRepository.save(existRestaurant);
}
    @Override
    public List<Restaurant> basedOnLocation(String location)
    {
        return restaurantRepository.findByLocation(location);
    }

    @Override
    public List<Restaurant> basedOnName(String restaurantName)
    {
        return restaurantRepository.findByRestaurantName(restaurantName);
    }

    @Override
    public List<Cuisines> deleteDish(String id, String foodName)
    {
        if (restaurantRepository.findById(id).isEmpty())
        {
            return null;
        }
        else
        {
            Restaurant restaurant= restaurantRepository.findById(id).get();
            List<Cuisines> existList= restaurant.getDishes();
            for (Cuisines dish: existList)
            {
                if (dish.getFoodName().equals(foodName))
                {
                    existList.remove(dish);
                    break;
                }
            }
            restaurant.setDishes(existList);
            restaurantRepository.save(restaurant);
            return restaurant.getDishes();
        }
    }

    @Override
    public Set<String> citiesName() {
        Set<String> cities=new HashSet<>();
        List<Restaurant> list= restaurantRepository.findAll();
        for (Restaurant restaurant: list){
            cities.add(restaurant.getLocation());
        }
        System.out.println(cities);
        return cities;
    }

}
