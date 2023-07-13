package com.niit.UserRegisterService.repository;


import com.niit.UserRegisterService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User,String>{

}
