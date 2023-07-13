package com.niit.UserAuthenticationService.controller;

import com.niit.UserAuthenticationService.domain.User;
import com.niit.UserAuthenticationService.exception.InvalidCredentialsException;
import com.niit.UserAuthenticationService.exception.UserAlreadyExistsException;
import com.niit.UserAuthenticationService.security.SecurityTokenGenerator;
import com.niit.UserAuthenticationService.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;
    private SecurityTokenGenerator securityTokenGenerator;

    @Autowired
    public UserController(UserService userService, SecurityTokenGenerator securityTokenGenerator) {
        this.userService = userService;
        this.securityTokenGenerator = securityTokenGenerator;
    }
    @PostMapping("/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
        return new ResponseEntity<>(userService.saveUser(user),HttpStatus.CREATED);
    }
    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@RequestBody User user) throws InvalidCredentialsException
    {
        User retrievedUser = userService.findByEmailAndPassword(user.getEmail(),user.getPassword());

        if(retrievedUser==null)
        {
            throw new InvalidCredentialsException();
        }
        Map<String,String> map = securityTokenGenerator.generateToken(user);
        return new ResponseEntity<>(map,HttpStatus.OK);
    }

//    @PutMapping("/user/Image/{email}")
//    public ResponseEntity<?> saveUser(@PathVariable String email,@RequestBody byte[] data){
//        System.out.println(email + " pic " + data);
//        return new ResponseEntity<>(userService.saveImage(data,email),HttpStatus.OK);
//    }
    @GetMapping("/user/{email}")
    public ResponseEntity<?> GetUser(@PathVariable String email){
        System.out.println(email);
        return new ResponseEntity<>(userService.getUser(email),HttpStatus.OK);
    }


}
