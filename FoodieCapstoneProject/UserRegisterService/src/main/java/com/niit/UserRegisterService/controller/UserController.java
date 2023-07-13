package com.niit.UserRegisterService.controller;


import com.niit.UserRegisterService.domain.User;
import com.niit.UserRegisterService.exception.UserAlreadyExistsException;
import com.niit.UserRegisterService.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin(origins ="http://localhost:4200")
@RestController
@RequestMapping("/api/v5")
public class UserController {

    private IUserService iUserService;

    @Autowired
    public UserController(IUserService iUserService ) {
        this.iUserService = iUserService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<?> saveUser(@RequestBody User user) throws UserAlreadyExistsException {
          return new ResponseEntity<>(iUserService.saveUser(user), HttpStatus.CREATED);
    }
    @GetMapping("/user/{email}")
    public ResponseEntity<?> GetUser(@PathVariable String email){
        System.out.println(email);
        return new ResponseEntity<>(iUserService.getUser(email),HttpStatus.OK);
    }

}
