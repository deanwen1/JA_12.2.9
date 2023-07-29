package com.example.reactivewebappclient;

import com.example.reactivewebappclient.client.UserWebClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReactiveWebAppClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReactiveWebAppClientApplication.class, args);

        UserWebClient webClient = new UserWebClient();
        webClient.getAllUsersAndLastUserOfList();
    }

}
