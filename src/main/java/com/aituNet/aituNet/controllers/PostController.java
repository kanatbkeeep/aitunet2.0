package com.aituNet.aituNet.controllers;


import com.aituNet.aituNet.entities.Post;
import com.aituNet.aituNet.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/addPost")
    public ResponseEntity savePost(@RequestBody Post post) {
        postService.savePost(post);
        return new ResponseEntity("Post created", HttpStatus.CREATED);
    }



}
