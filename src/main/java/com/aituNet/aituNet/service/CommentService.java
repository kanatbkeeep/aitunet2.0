package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Comment;
import org.springframework.stereotype.Service;


@Service
public interface CommentService {
    Comment saveComment(Comment comment);

}
