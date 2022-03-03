package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Comment;
import com.aituNet.aituNet.repo.CommentRepo;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class CommentServiceImpl implements CommentService{
    private final CommentRepo commentRepo;


    public CommentServiceImpl(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }


    @Override
    public Comment saveComment(Comment comment) {
        log.info("Comment was added to {}",comment.getPostId());
        return commentRepo.save(comment);
    }

    @Override
    public List<Comment> ShowCommentsByPostId(Integer id) {
        return commentRepo.findAllByPostId(id);
    }
}
