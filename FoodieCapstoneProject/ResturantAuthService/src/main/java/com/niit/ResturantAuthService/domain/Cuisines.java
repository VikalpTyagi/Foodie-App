package com.niit.ResturantAuthService.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

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
