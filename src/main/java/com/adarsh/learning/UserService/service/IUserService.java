package com.adarsh.learning.UserService.service;

import java.util.List;
import java.util.Optional;

import com.adarsh.learning.UserService.dto.User;

public interface IUserService {

  // create operations
  User createUser(User user);

  // read operations
  Optional<User> getUserById(String id);

  Optional<User> getUserByEmail(String email);

  Optional<User> getUserByPhoneNumber(String phoneNumber);

  List<User> getAllUsers();

  List<User> getUsersByName(String name);

  // update operations
  User updateUser(String id, User user);

  // delete operations
  boolean deleteUser(String id);

  // utility operation
  boolean isEmailExists(String email);

  boolean isPhoneNumberExists(String phoneNumber);

  boolean isUserExists(String id);

  // exception handling
  default User validateAndReturnUser(String id) {
    return getUserById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
  }
}
