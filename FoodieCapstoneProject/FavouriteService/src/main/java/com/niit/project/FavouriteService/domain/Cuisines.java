package com.niit.project.FavouriteService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cuisines {

    private String foodName;
    private double foodRating;
    private String foodType;
    private String foodDescription;
    private double foodPrice;
    private String foodImg;
}
