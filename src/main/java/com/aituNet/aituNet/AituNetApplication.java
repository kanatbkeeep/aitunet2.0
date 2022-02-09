package com.aituNet.aituNet;


import com.aituNet.aituNet.entities.User;
import com.aituNet.aituNet.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;

@SpringBootApplication
public class AituNetApplication {

    public static void main(String[] args) {
        SpringApplication.run(AituNetApplication.class, args);
    }

    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveUser(new User("asd", "asd", "sd", new ArrayList<>(), new ArrayList<>()));
			userService.addRoleToUser("asd", "ROLE_USER");
        };
    }
}