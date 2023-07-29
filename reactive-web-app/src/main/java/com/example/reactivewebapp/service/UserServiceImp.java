package com.example.reactivewebapp.service;

import com.example.reactivewebapp.model.User;
import com.example.reactivewebapp.repository.UserMongoRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class UserServiceImp implements UserService {

    private final UserMongoRepository userMongoRepository;

    @Override
    public Flux<User> getAllUsers() {
        return userMongoRepository.findAll();
    }

    @Override
    public Mono<User> getUserById(Long id) {
        return userMongoRepository.findById(id);
    }

    @Override
    public Mono<User> addUser(User user) {
        return userMongoRepository.save(user);
    }
}