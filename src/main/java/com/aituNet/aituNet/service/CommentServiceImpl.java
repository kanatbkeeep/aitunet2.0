package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Comment;
import com.aituNet.aituNet.repo.CommentRepo;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService{
    private final CommentRepo commentRepo;


    public CommentServiceImpl(CommentRepo commentRepo) {this.commentRepo = commentRepo;}



    @Override
    public Comment saveComment(Comment comment) {
        return commentRepo.save(comment);
    }
}
