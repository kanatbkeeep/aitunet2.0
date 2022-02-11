package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.Post;
import com.aituNet.aituNet.request.GetByAuthorId;
import com.aituNet.aituNet.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
public class PostController {
    private final PostService postService;

    @PostMapping("/addPost")
    public ResponseEntity savePost(@RequestBody Post post) {
        postService.savePost(post);
        return new ResponseEntity("post created", HttpStatus.CREATED);
    }

    @GetMapping("/getByAuthorId")
    public ResponseEntity<List<Post>> getByAuthorId(@RequestBody(required = false) GetByAuthorId getByAuthorId) {
        return ResponseEntity.ok().body(postService.findByAuthorId(getByAuthorId.getAuthorId()));
    }
}
