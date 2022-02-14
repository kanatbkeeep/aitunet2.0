package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.User;
import com.aituNet.aituNet.request.UpdateAboutMeRequest;
import com.aituNet.aituNet.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/updateAboutMe")
    public ResponseEntity updateAboutMe(@RequestBody UpdateAboutMeRequest updateAboutMeRequest) {
        userService.updateAboutMe(updateAboutMeRequest.getUsername(), updateAboutMeRequest.getNewValue());
        return new ResponseEntity("about me updated", HttpStatus.CREATED);
    }

    @GetMapping("/getUserByUsername")
    public ResponseEntity<User>getUserByUsername(@RequestParam String username) {
        return ResponseEntity.ok().body(userService.getUserByUsername(username));
    }

    @GetMapping("/getUserById")
    public ResponseEntity<User>getUserById(@RequestParam Integer id) {
        return ResponseEntity.ok().body(userService.getUserById(id));
    }
}
