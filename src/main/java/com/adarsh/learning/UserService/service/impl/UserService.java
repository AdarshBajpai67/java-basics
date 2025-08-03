package com.adarsh.learning.UserService.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import com.adarsh.learning.UserService.dto.User;
import com.adarsh.learning.UserService.repository.UserRepository;
import com.adarsh.learning.UserService.service.IUserService;

import jakarta.validation.Valid;

@Service
public class UserService implements IUserService {

  @Autowired
  private UserRepository userRepository;

  @Override
  public User createUser(User user) {
    if (isEmailExists(user.getEmail())) {
      throw new RuntimeException("Email Already Exists" + user.getEmail());
    }

    return userRepository.save(user);
  }

  @Override
  public Optional<User> getUserById(String id) {
    return userRepository.findById(id);
  }

  @Override
  public Optional<User> getUserByEmail(String email) {
    return userRepository.findByEmail(email);
  }

  @Override
  public Optional<User> getUserByPhoneNumber(String phoneNumber) {
    return userRepository.findByPhoneNumber(phoneNumber);
  }

  @Override
  public List<User> getAllUsers() {
    return userRepository.findAll();
  }

  @Override
  public List<User> getUsersByName(String name) {
    return userRepository.findByNameContaining(name);
  }

  @Override
  public User updateUser(String id, @Valid @RequestBody User user) {
    User existingUser = validateAndReturnUser(id);
    existingUser.setName(user.getName());
    existingUser.setEmail(user.getEmail());
    existingUser.setPhoneNumber(user.getPhoneNumber());

    if (user.getPassword() != null && !user.getPassword().isEmpty()) {
      existingUser.setPassword(user.getPassword());
    }

    return userRepository.save(existingUser);
  }

  @Override
  public boolean deleteUser(String id) {
    User existingUser = validateAndReturnUser(id);
    userRepository.delete(existingUser);
    return true;
  }

  @Override
  public boolean isEmailExists(String email) {
    return userRepository.existsByEmail(email);
  }

  @Override
  public boolean isPhoneNumberExists(String phoneNumber) {
    return userRepository.existsByPhoneNumber(phoneNumber);
  }

  @Override
  public boolean isUserExists(String id) {
    return userRepository.existsById(id);
  }
}
