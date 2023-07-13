package com.niit.UserRegisterService.service;


import com.niit.UserRegisterService.domain.User;
import com.niit.UserRegisterService.exception.UserAlreadyExistsException;
import com.niit.UserRegisterService.proxy.UserProxy;
import com.niit.UserRegisterService.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    private UserRepository userRepository;
    @Autowired
    private UserProxy userProxy;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;

    }

    @Override
    public User saveUser(User user) throws UserAlreadyExistsException {
        if (userRepository.findById(user.getEmail()).isPresent()) {
            throw new UserAlreadyExistsException();
        }
        userProxy.saveUser(user);
//        User savedUser= userRepository.save(user);
//        if(!(savedUser.getEmail().isEmpty())) {
//            ResponseEntity response = userProxy.saveUser(user);
//            System.out.println(response.getBody());
//        }
        return userRepository.save(user);
    }

    @Override
    public User getUser(String email){
        return userRepository.findById(email).get();
    }
}
