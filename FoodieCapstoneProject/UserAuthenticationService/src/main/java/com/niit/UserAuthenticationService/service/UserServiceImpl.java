package com.niit.UserAuthenticationService.service;

import com.niit.UserAuthenticationService.domain.User;
import com.niit.UserAuthenticationService.exception.InvalidCredentialsException;
import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.UserAuthenticationService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if(userRepository.findById(user.getEmail()).isPresent())
        {
            throw new UserAlreadyExistsException();
        }
        System.out.println(user);
        return userRepository.save(user);
    }

    @Override
    public User findByEmailAndPassword(String email, String password) throws InvalidCredentialsException {
        User loggedInUser = userRepository.findByEmailAndPassword(email,password);
        if(loggedInUser == null)
        {
            throw new InvalidCredentialsException();
        }
        return loggedInUser;
    }

//    @Override
//    public User saveImage(byte[] image, String email){
//        Optional<User> findUser= userRepository.findById(email);
//        if (findUser.isEmpty()){
//            return null;
//        }
//        else{
//            User existUser=findUser.get();
//            existUser.setUserImg(image);
//            return userRepository.save(existUser);
//        }
//    }
    @Override
    public User getUser(String email){
        return userRepository.findById(email).get();
    }

}
