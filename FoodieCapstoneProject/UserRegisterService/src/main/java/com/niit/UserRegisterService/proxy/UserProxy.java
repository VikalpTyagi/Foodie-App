package com.niit.UserRegisterService.proxy;


import com.niit.UserRegisterService.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name="user-authentication-service",url ="localhost:8081")
public interface UserProxy {
    @PostMapping("/api/v1/register")
    ResponseEntity<?>saveUser(@RequestBody User user);
}
