package com.santam.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santam.workshopmongo.domain.User;
import com.santam.workshopmongo.dto.UserDTO;
import com.santam.workshopmongo.repositorie.UserRepository;
import com.santam.workshopmongo.services.exceptions.ResourceNotFoundException;

// falar que pode ser injetável em outras class @Autowired
@Service
public class UserService {
  @Autowired
  private UserRepository repository;

  public List<User> findAll() {
    return repository.findAll();
  }

  public User findById(String id) {
    Optional<User> user = repository.findById(id);
    return user.orElseThrow(() -> new ResourceNotFoundException(id));
  }

  public User insert(User obj) {
    return repository.insert(obj);
  }

  public void delete(String id) {
    findById(id);
    repository.deleteById(id);
  }

  public User fromDTO(UserDTO dto) {
    return new User(dto.getId(), dto.getName(), dto.getEmail());
  }
}
