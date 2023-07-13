package com.niit.project.FavouriteService.controller;

import com.niit.project.FavouriteService.domain.Restaurant;
import com.niit.project.FavouriteService.exception.RestaurantAlreadyExist;
import com.niit.project.FavouriteService.exception.UserNotFound;
import com.niit.project.FavouriteService.service.FavouriteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins ="http://localhost:4200")
@RequestMapping("/api/v3")
@RestController

public class myController {


    FavouriteService service;

    @Autowired
    public myController(FavouriteService service) {
        this.service = service;
    }

    private ResponseEntity response;

    @PostMapping("/favourite/add/{email}")
    public ResponseEntity<?> addToFavourites(@RequestBody Restaurant restaurant, @PathVariable String email) throws UserNotFound, RestaurantAlreadyExist {
        System.out.println(restaurant+ "dd" + email);
        ResponseEntity<Object> responseEntity;
        try {
            responseEntity = new ResponseEntity<>(service.addRestaurantToFavourite(restaurant, email), HttpStatus.OK);
        } catch (UserNotFound e) {
            throw new UserNotFound();
        } catch (RestaurantAlreadyExist e) {
            throw new RestaurantAlreadyExist();
        } catch (Exception e) {
            responseEntity = new ResponseEntity<>("Error try save after sometime", HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return responseEntity;
    }

    @DeleteMapping("/favourite/delete/{id}/{email}")
    public ResponseEntity<?> deleteBookmark(@PathVariable String id, @PathVariable String email) throws UserNotFound {
        try{
            response=new ResponseEntity<>(service.deleteFavourite(id,email),HttpStatus.OK);
        }
        catch (UserNotFound e)
        {
            throw new UserNotFound();
        }
        catch (Exception e)
        {
            response=new ResponseEntity<>("Error try after Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

    @GetMapping("favourite/fetch/{email}")
    public ResponseEntity<?> getBookmarkByBookmarkName(@PathVariable String email)
    {
        try{
            response=new ResponseEntity(service.getAllFavourites( email),HttpStatus.OK);
        }
        catch (Exception e){
            response=new ResponseEntity<>("Error try After Sometime",HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return response;
    }

}
