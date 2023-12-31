package com.santam.workshopmongo.resource;

import java.time.Instant;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.santam.workshopmongo.domain.Post;
import com.santam.workshopmongo.resource.util.URL;
import com.santam.workshopmongo.services.PostService;

@RestController
@RequestMapping(value = "/posts")
public class PostResource {
  @Autowired
  private PostService service;

  // @GetMapping(value = "/titlesearch")
  // public ResponseEntity<List<Post>> findByTitle(@RequestParam(value = "text", defaultValue = "") String text) {
  //   text = URL.decodeParam(text);
  //   List<Post> posts = service.findByTitle(text);

  //   return ResponseEntity.ok().body(posts);
  // }

  @GetMapping
  public ResponseEntity<List<Post>> findAll(@RequestParam(value = "title", defaultValue = "") String title) {
    title = URL.decodeParam(title);
    List<Post> posts = service.findByTitle(title);
    return ResponseEntity.ok().body(posts);
  }

  @GetMapping(value = "/{id}")
  public ResponseEntity<Post> findById(@PathVariable String id) {
    Post post = service.findById(id);
    return ResponseEntity.ok().body(post);
  }

  @GetMapping(value = "/fullsearch")
  public ResponseEntity<List<Post>> fullSearch(
    @RequestParam(value = "title", defaultValue = "") String title,
    @RequestParam(value = "minDate", defaultValue = "") String minDate,
    @RequestParam(value = "maxDate", defaultValue = "") String maxDate
  ) {
    title = URL.decodeParam(title);
    Instant min = URL.convertDate(minDate, Instant.EPOCH);
    Instant max = URL.convertDate(maxDate, Instant.now());

    List<Post> posts = service.fullSearch(title, min, max);
    return ResponseEntity.ok().body(posts);
  }
}
