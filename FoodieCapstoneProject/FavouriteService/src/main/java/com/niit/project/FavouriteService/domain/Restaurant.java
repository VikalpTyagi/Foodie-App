package com.niit.project.FavouriteService.domain;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Restaurant {

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

}
