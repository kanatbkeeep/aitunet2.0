package com.aituNet.aituNet.controllers;

import com.aituNet.aituNet.entities.Comment;
import com.aituNet.aituNet.entities.User;
import com.aituNet.aituNet.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/comment")
public class CommentController {
    private final CommentService commentService;

    @PostMapping("/save")
    public ResponseEntity saveComment(@RequestBody Comment comment) {
        commentService.saveComment(comment);
        return new ResponseEntity("Comment saved", HttpStatus.CREATED);
    }
}
