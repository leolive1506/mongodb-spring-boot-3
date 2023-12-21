package com.santam.workshopmongo.repositorie;

import org.springframework.stereotype.Repository;
import com.santam.workshopmongo.domain.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface PostRepository extends MongoRepository<Post, String> {
  
}
