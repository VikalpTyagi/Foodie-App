package com.niit.project.FavouriteService.repository;


import com.niit.project.FavouriteService.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FavouriteRepository extends MongoRepository<User,String> {

}
