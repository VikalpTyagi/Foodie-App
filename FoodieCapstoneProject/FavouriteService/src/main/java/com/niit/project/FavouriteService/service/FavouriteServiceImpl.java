package com.niit.project.FavouriteService.service;

import com.niit.project.FavouriteService.domain.Favourite;
import com.niit.project.FavouriteService.domain.Restaurant;
import com.niit.project.FavouriteService.domain.User;
import com.niit.project.FavouriteService.exception.RestaurantAlreadyExist;
import com.niit.project.FavouriteService.exception.RestaurantNotFound;
import com.niit.project.FavouriteService.exception.UserNotFound;
import com.niit.project.FavouriteService.repository.FavouriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FavouriteServiceImpl implements FavouriteService{

    private FavouriteRepository  repos;

    @Autowired
    public FavouriteServiceImpl(FavouriteRepository repos) {
        this.repos = repos;
    }

    @Override
    public User addRestaurantToFavourite(Restaurant restaurant, String email) throws UserNotFound, RestaurantAlreadyExist {
        if(repos.findById(email).isEmpty())
        {
            User user = new User();
            user.setEmail(email);
            repos.save(user);
        }
        User user = (User) repos.findById(email).get();
        if (user.getFavourite()==null)
        {
            Favourite favourite = new Favourite();
            favourite.setFavouriteId((int)Math.random()*10);

            List<Restaurant> restaurantList = new ArrayList<>();
            restaurantList.add(restaurant);
            favourite.setRestaurant(restaurantList);
            user.setFavourite(favourite);
            repos.save(user);
            return user;
        }
        else {
            Favourite favourite =user.getFavourite();
            List<Restaurant> allRestaurant = favourite.getRestaurant();
            for (Restaurant restro : allRestaurant)
            {
                if (restro.getRestaurantId().equals(restaurant.getRestaurantId()))
                {
                    throw new RestaurantAlreadyExist();
                }
            }
            allRestaurant.add(restaurant);
            favourite.setRestaurant(allRestaurant);
            user.setFavourite(favourite);
            repos.save(user);
            return user;
        }

    }

    @Override
    public User deleteFavourite(String id, String email) throws UserNotFound, RestaurantNotFound {
        User userRepo = new User();
        if (repos.findById(email).isEmpty())
        {
         return null;
        }
        User user=repos.findById(email).get();
        Favourite favourite = user.getFavourite();
        List<Restaurant> restaurantList = user.getFavourite().getRestaurant();
        for (Restaurant restro : restaurantList)
        {
            if (restro.getRestaurantId().equals(id))
            {
                restaurantList.remove(restro);
                favourite.setRestaurant(restaurantList);
                user.setFavourite(favourite);
                userRepo = repos.save(user);
                break;
            }
        }
        return userRepo;
    }

    @Override
    public List<Restaurant> getAllFavourites( String email) throws RestaurantNotFound {
        if (repos.findById(email).isEmpty())
        {
            throw new RestaurantNotFound();
        }
        User user = repos.findById(email).get();
        Favourite favourite = user.getFavourite();
        return favourite.getRestaurant();
    }
}
