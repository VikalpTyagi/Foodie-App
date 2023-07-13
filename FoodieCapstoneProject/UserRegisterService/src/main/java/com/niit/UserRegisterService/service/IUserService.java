package com.niit.UserRegisterService.service;



import com.niit.UserRegisterService.domain.User;
import com.niit.UserRegisterService.exception.UserAlreadyExistsException;

public interface IUserService {
   public User saveUser(User user) throws UserAlreadyExistsException;

   User getUser(String email);
}
