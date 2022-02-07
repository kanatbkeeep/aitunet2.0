package com.aituNet.aituNet.controllers;


import com.aituNet.aituNet.entity.Post;
import com.aituNet.aituNet.requests.PostRequest;
import com.aituNet.aituNet.services.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/user/post")
@RequiredArgsConstructor
public class PostController {
    private PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }


    @PostMapping("/create")
    public ResponseEntity savePost(@RequestBody Post post) {

        postService.savePost(post);
        return new ResponseEntity("Post created", HttpStatus.CREATED);
    }


    @PostMapping("/delete")
    public ResponseEntity deletePost(@RequestBody PostRequest postRequest) {
        boolean result = postService.deletePost(postRequest);
        if (result) {
            return new ResponseEntity("Post deleted", HttpStatus.OK);
        }
        return ResponseEntity.badRequest().body("bad request");
    }

    @GetMapping("/getPostByName")
    public ResponseEntity<Post> getPostByName(@RequestParam String name) {
        return ResponseEntity.ok().body(postService.getPostByName(name));
    }

    @GetMapping("/getPostByDate")
    public ResponseEntity<Post> getPostByDate(@RequestParam Date date) {
        return ResponseEntity.ok().body(postService.getPostByDate(date));
    }

    @PostMapping("/update")
    public ResponseEntity updatePost(@RequestBody PostRequest postRequest) {
        if(postRequest.getName().equals("name")) {
            Post postEdit = postService.getPostByName(postRequest.getName());
            postEdit.setName(postRequest.getName());
            postService.updatePost(postEdit.getText(),postEdit.getName());
            return ResponseEntity.ok().body("Updated");
        } else if(postRequest.getText().equals("text")) {
            Post postEdit = postService.getPostByName(postRequest.getText());
            postService.updatePost(postEdit.getText(),postEdit.getName());
            return ResponseEntity.ok().body("Updated");
        } else {
            return ResponseEntity.badRequest().body("Incorrect parameter");
        }
    }
    @GetMapping("/all")
    public ResponseEntity allPosts() {
        List<Post> posts = postService.getPosts();
        if (posts == null || posts.size() == 0) {
            return new ResponseEntity("Posts not found", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(posts);
    }
}



