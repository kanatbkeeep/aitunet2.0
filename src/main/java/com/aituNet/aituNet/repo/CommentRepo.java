package com.aituNet.aituNet.repo;

import com.aituNet.aituNet.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepo extends JpaRepository<Comment, Long>  {

    List<Comment> findCommentsByPostId(Integer id);
    List<Comment> findAllByPostId(Integer id);
    List<Comment> getCommentsByPostId(Integer id);
}
