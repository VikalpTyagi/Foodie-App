package com.niit.ResturantAuthService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Restaurant {
    @Id
    private String restaurantId;
    private String password;
    private String restaurantOwnerName;
    private String restaurantName;
    private String location;
    private String phNo;
    private String restaurantImg;
    private float restaurantRating;
    private String description;
    private String address;
    private List<Cuisines> dishes;

    //to add dish with help of save function
    public void addDish(Cuisines dish) {
       this.dishes.add(dish) ;
    }
}
