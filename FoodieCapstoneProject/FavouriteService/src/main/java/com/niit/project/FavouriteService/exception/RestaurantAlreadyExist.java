package com.niit.project.FavouriteService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.ALREADY_REPORTED,reason = "Restaurant already present !!")
public class RestaurantAlreadyExist extends Exception {
}
