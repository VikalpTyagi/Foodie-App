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
public class Favourite {

    private int favouriteId;
    private List<Restaurant> restaurant;
}
