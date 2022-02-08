package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.User;
import com.aituNet.aituNet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @PostMapping("/registration")
    public ResponseEntity saveUser(@RequestBody User user) {
        if(userService.exitUser(user.getUsername())) {
            return ResponseEntity.badRequest().body("User with this username already exist");
        }
        userService.saveUser(user);
        userService.addRoleToUser(user.getUsername(), "ROLE_USER");
        return new ResponseEntity("user created", HttpStatus.CREATED);
    }
}
