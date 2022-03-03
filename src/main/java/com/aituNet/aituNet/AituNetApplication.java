package com.aituNet.aituNet;


import com.aituNet.aituNet.entities.Application;
import com.aituNet.aituNet.entities.User;
import com.aituNet.aituNet.service.UserService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.context.annotation.Bean;


import java.util.ArrayList;
@SpringBootApplication
public class AituNetApplication {

    private static final Logger LOGGER = LogManager.getLogger(Application.class);

    public static void main(String[] args) {
        SpringApplication.run(AituNetApplication.class, args);

    }
    @Bean
    CommandLineRunner run(UserService userService) {
        return args -> {
            userService.saveUser(new User("asd", "asd", "AHAHAHAHHA", new ArrayList<>(), new ArrayList<>()));
        };
    }
}