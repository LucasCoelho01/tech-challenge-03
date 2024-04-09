package com.lucas.techchallenge.repositories;

import com.lucas.techchallenge.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, Long> {
}
