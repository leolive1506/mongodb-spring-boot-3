package com.santam.workshopmongo.repositorie;

import org.springframework.stereotype.Repository;
import com.santam.workshopmongo.domain.User;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface UserRepository extends MongoRepository<User, String> {
  
}
