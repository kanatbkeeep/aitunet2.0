package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.Greeting;
import com.aituNet.aituNet.entities.HelloMessage;
import com.aituNet.aituNet.entities.User;
import com.aituNet.aituNet.repo.UserRepo;
import com.aituNet.aituNet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.util.HtmlUtils;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class GreetingController {
    @Autowired
    private  UserRepo userRepo;

    private final UserService userService;


    @MessageMapping("/hello")
    @SendTo("/topic/greetings")
    public Greeting greeting(HelloMessage message) throws Exception {
        Thread.sleep(1000); // simulated delay
        return new Greeting("Hello, " + HtmlUtils.htmlEscape(message.getName()) + "!");
    }
    @GetMapping("/user")
    @SendTo("/topic/user")
    public List<User> users() throws Exception {
        Thread.sleep(1000); // simulated delay
        return userService.getUsers();
    }
}
