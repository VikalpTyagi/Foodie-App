package com.niit.ResturantAuthService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE,reason = "Restaurant Already Exist")
public class RestaurantAlreadyExistException extends Exception{
}
