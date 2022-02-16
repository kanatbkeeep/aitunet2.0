package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Comment;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public interface CommentService {
    Comment saveComment(Comment comment);
    List<Comment> ShowCommentsByPostId(Integer id);
}
