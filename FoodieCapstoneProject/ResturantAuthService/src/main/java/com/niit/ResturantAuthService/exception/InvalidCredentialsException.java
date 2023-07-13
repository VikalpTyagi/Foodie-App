package com.niit.ResturantAuthService.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND,reason = "Restaurant not Found")
public class InvalidCredentialsException extends Exception{
}
