package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.Comment;
import com.aituNet.aituNet.entities.User;
import com.aituNet.aituNet.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/send")
    public ResponseEntity saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
        return new ResponseEntity("Comment saved", HttpStatus.CREATED);
    }
    @GetMapping("/show")
    public ResponseEntity ShowCommentByPost(@RequestParam Integer id) {
        return ResponseEntity.ok().body(commentService.ShowCommentsByPostId(id));
    }
}
