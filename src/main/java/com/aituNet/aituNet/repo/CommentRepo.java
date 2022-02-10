package com.aituNet.aituNet.repo;

import com.aituNet.aituNet.entities.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepo extends JpaRepository<Comment, Long>   {
}
