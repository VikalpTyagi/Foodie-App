package com.niit.UserAuthenticationService.repository;


import com.niit.UserAuthenticationService.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
User findByEmailAndPassword(String email, String password);
}
