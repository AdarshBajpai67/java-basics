package com.adarsh.learning.UserService.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.adarsh.learning.UserService.dto.User;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  Optional<User> findByEmail(String email);
  boolean existsByEmail(String email);
  
  Optional<User> findByPhoneNumber(String phoneNumber);
  boolean existsByPhoneNumber(String phoneNumber);

  @Query("{name:{$regex:?0,$options:'i'}}")
  List<User> findByNameContaining(String namePattern);

  
}
