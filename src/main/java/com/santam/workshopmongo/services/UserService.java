package com.santam.workshopmongo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santam.workshopmongo.domain.User;
import com.santam.workshopmongo.repositorie.UserRepository;

// falar que pode ser injetável em outras class @Autowired
@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }
}
