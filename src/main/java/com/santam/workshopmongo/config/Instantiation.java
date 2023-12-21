package com.santam.workshopmongo.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import com.santam.workshopmongo.domain.Post;
import com.santam.workshopmongo.domain.User;
import com.santam.workshopmongo.dto.AuthorDTO;
import com.santam.workshopmongo.repositorie.PostRepository;
import com.santam.workshopmongo.repositorie.UserRepository;

@Configuration
public class Instantiation implements CommandLineRunner {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private PostRepository postRepository;

  @Override
  public void run(String... args) throws Exception {
    userRepository.deleteAll();
    postRepository.deleteAll();

    User maria = new User(null, "Maria Brown", "maria@gmail.com");
    User alex = new User(null, "Alex Green", "alex@gmail.com");
    User bob = new User(null, "Bob Grey", "bob@gmail.com");

    userRepository.saveAll(Arrays.asList(maria, alex, bob));

    AuthorDTO author = new AuthorDTO(maria);
    Post post1 = new Post(null, Instant.now(), "Partiu viagem", "Vou viajar para São Paulo. Abraços!", author);
    Post post2 = new Post(null, Instant.now(), "Bom dia", "Acordei feliz hoje!", author);

    postRepository.saveAll(Arrays.asList(post1, post2));

    maria.getPosts().addAll(Arrays.asList(post1, post2));
    userRepository.save(maria);
  }
}
