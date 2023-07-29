package com.example.reactivewebapp.configuration;

import com.example.reactivewebapp.model.User;
import com.example.reactivewebapp.service.UserService;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.ArrayList;
import java.util.List;


@Component
public class UserDataLoader {

    private final UserService userService;

    private final List<User> userList;

    {
        userList = new ArrayList<>();
        userList.add(User.builder().id(1L).name("Name1").lastName("LastName1").build());
        userList.add(User.builder().id(2L).name("Name2").lastName("LastName2").build());
        userList.add(User.builder().id(3L).name("Name3").lastName("LastName3").build());
        userList.add(User.builder().id(4L).name("Name4").lastName("LastName4").build());
        userList.add(User.builder().id(5L).name("Name5").lastName("LastName5").build());
    }

    public UserDataLoader(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    public void dataLoader() {

        Flux.fromIterable(userList).flatMap(userService::addUser)
                .subscribe(System.out::println);
    }
}