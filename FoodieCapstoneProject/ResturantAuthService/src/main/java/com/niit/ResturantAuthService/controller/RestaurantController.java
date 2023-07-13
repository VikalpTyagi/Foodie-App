package com.niit.ResturantAuthService.controller;

import com.niit.ResturantAuthService.domain.Cuisines;
import com.niit.ResturantAuthService.domain.Restaurant;
import com.niit.ResturantAuthService.security.SecurityTokenGenerator;
import com.niit.ResturantAuthService.service.RestaurantServiceInterface;
import com.niit.ResturantAuthService.exception.InvalidCredentialsException;
import com.niit.ResturantAuthService.exception.RestaurantAlreadyExistException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v2")
public class RestaurantController {
    private RestaurantServiceInterface restaurantService;
    private SecurityTokenGenerator securityTokenGenerator;


    @Autowired
    public RestaurantController(RestaurantServiceInterface restaurantService, SecurityTokenGenerator securityTokenGenerator
    ) {
        this.restaurantService = restaurantService;
        this.securityTokenGenerator = securityTokenGenerator;

    }

    @PostMapping("/restaurant/register")
    ResponseEntity<?> registerRestaurant(@RequestBody Restaurant restaurant) throws RestaurantAlreadyExistException {
        return new ResponseEntity<>(restaurantService.saveRestaurant(restaurant), HttpStatus.CREATED);
    }

    @PostMapping("/restaurant/login")
    public ResponseEntity<?> loginRestaurant(@RequestBody Restaurant restaurant) throws InvalidCredentialsException {
        Restaurant retrievedRestaurant = restaurantService.loginRestaurant(restaurant.getRestaurantId(), restaurant.getPassword());
        if (retrievedRestaurant == null) {
            throw new InvalidCredentialsException();
        }
        Map<String, String> map = securityTokenGenerator.generateToken(restaurant);
        System.out.println(map);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
    @PostMapping("/cuisines/dish/{id}")
    public ResponseEntity<?> addCuisines(@PathVariable String id,@RequestBody Cuisines cuisines)
    {
        System.out.println(cuisines + "id" + id);
        return new ResponseEntity<>(restaurantService.saveCuisines(cuisines,id),HttpStatus.OK);
    }
    @GetMapping("/restaurant/get")
    public ResponseEntity<?> getDetails()
    {
        return new ResponseEntity<>(restaurantService.getDetails(),HttpStatus.OK);
    }

    @GetMapping("/restaurant/{id}")
    public ResponseEntity <?> getRestaurant(@PathVariable("id") String id) {
        return new ResponseEntity<>(restaurantService.getRestaurantById(id),HttpStatus.OK) ;
    }

    @GetMapping("/rest/{location}")
    public  ResponseEntity<?> findByLocation(@PathVariable("location") String location)
    {
        return new ResponseEntity<>(restaurantService.basedOnLocation(location),HttpStatus.OK);
    }

    @GetMapping("/restaurant/name/{restaurantName}")
    public ResponseEntity<?> findByName(@PathVariable String restaurantName)
    {
        return new ResponseEntity<>(restaurantService.basedOnName(restaurantName),HttpStatus.OK);
    }
    @DeleteMapping("/restaurant/delete/{restId}/{foodName}")
    public ResponseEntity<?> deleteDish(@PathVariable String restId,@PathVariable String foodName)
    {
        return new ResponseEntity<>(restaurantService.deleteDish(restId,foodName),HttpStatus.OK);
    }

    @GetMapping("/restaurant/listCities")
    public ResponseEntity<?> cityList()
    {
        return new ResponseEntity<>(restaurantService.citiesName(),HttpStatus.OK);
    }

}
