package com.santam.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.santam.workshopmongo.domain.Post;
import com.santam.workshopmongo.repositorie.PostRepository;
import com.santam.workshopmongo.services.exceptions.ResourceNotFoundException;

// falar que pode ser injetável em outras class @Autowired
@Service
public class PostService {
  @Autowired
  private PostRepository repository;

  public Post findById(String id) {
    Optional<Post> Post = repository.findById(id);
    return Post.orElseThrow(() -> new ResourceNotFoundException(id));
  }
}
