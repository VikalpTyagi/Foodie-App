package com.niit.UserAuthenticationService.service;


import com.niit.UserAuthenticationService.domain.User;
import com.niit.UserAuthenticationService.exception.InvalidCredentialsException;
import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;

public interface UserService {

    User saveUser(User user) throws UserAlreadyExistsException;

    User findByEmailAndPassword(String email,String password) throws InvalidCredentialsException;


//    User saveImage(byte[] image, String email);

    User getUser(String email);
}
