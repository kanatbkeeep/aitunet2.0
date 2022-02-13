package com.aituNet.aituNet.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/loginUser")
    public String login() {
        return "login";
    }

    @GetMapping("/registration")
    public String register() {
        return "registration";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/request")
    public String request() {
        return "request";
    }

    @GetMapping("/sample")
    public String sample() {
        return "sample";
    }

    @GetMapping("/editPost")
    public String editPost() { return "editPost";
    }
    @GetMapping("/friends")
    public String friends() { return "friends";
    }
}
