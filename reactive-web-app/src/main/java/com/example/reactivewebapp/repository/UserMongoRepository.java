package com.example.reactivewebapp.repository;

import com.example.reactivewebapp.model.User;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface UserMongoRepository extends ReactiveMongoRepository<User, Long> {

}
