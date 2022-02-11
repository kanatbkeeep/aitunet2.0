package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.Post;
import com.aituNet.aituNet.request.DeletePostRequest;
import com.aituNet.aituNet.request.GetByAuthorId;
import com.aituNet.aituNet.request.UpdatePostRequest;
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

    @PostMapping("/updatePost")
    public ResponseEntity updatePost(@RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(updatePostRequest.getPost_id(), updatePostRequest.getNewValue());
        return new ResponseEntity("post is updated", HttpStatus.CREATED);
    }

    @PostMapping("/deletePost")
    public ResponseEntity deletePost(@RequestBody DeletePostRequest deletePostRequest) {
        postService.deletePost(Integer.valueOf(deletePostRequest.getPost_id()));
        return new ResponseEntity("post is deleted", HttpStatus.CREATED);
    }

    @GetMapping("/getByAuthorId")
    public ResponseEntity<List<Post>> getByAuthorId(@RequestBody GetByAuthorId getByAuthorId) {
        return ResponseEntity.ok().body(postService.findByAuthorId(getByAuthorId.getAuthor_id()));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok().body(postService.findAll());
    }


}
