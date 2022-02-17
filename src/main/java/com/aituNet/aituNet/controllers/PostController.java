package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.Post;
import com.aituNet.aituNet.request.DeletePostRequest;
import com.aituNet.aituNet.request.GetByAuthorId;
import com.aituNet.aituNet.request.UpdatePostRequest;
import com.aituNet.aituNet.service.PostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/post")
@Slf4j
public class PostController {
    private final PostService postService;

    @PostMapping("/addPost")
    public ResponseEntity savePost(@RequestBody Post post) {
        postService.savePost(post);
        return new ResponseEntity("post created", HttpStatus.CREATED);
    }

    @PostMapping("/updatePost")
    public ResponseEntity updatePost(@RequestBody UpdatePostRequest updatePostRequest) {
        postService.updatePost(updatePostRequest.getPostId(), updatePostRequest.getNewValue());
        return new ResponseEntity("post is updated", HttpStatus.CREATED);
    }

    @PostMapping("/deletePost")
    public ResponseEntity deletePost(@RequestBody DeletePostRequest deletePostRequest) {
        postService.deletePost((deletePostRequest.getPostId()));
        return new ResponseEntity("post is deleted", HttpStatus.CREATED);
    }

    @GetMapping("/getByAuthorId")
    public ResponseEntity<List<Post>> getByAuthorId(@RequestParam Integer authorId) {
        return ResponseEntity.ok().body(postService.findByAuthorId(authorId));
    }

    @GetMapping("/getPostByIdParam")
    public ResponseEntity<Post> getPostById(@RequestParam Integer postId) {
        return ResponseEntity.ok().body(postService.findPostById(postId));
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Post>> getAll() {
        return ResponseEntity.ok().body(postService.findAll());
    }


    @MessageMapping("/ws.send")
    @SendTo("/topic/ws")
    public Post sendPost(@Payload final Post post) {
        System.out.println("send post func ");
        postService.savePost(post);
        return post;
    }

    @MessageMapping("/getAllPost")
    @SendTo("/topic/getPosts")
    public ResponseEntity<List<Post>> getPosts() {
        return ResponseEntity.ok().body(postService.findAll());
    }
}
