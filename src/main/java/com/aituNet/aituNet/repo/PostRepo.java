package com.aituNet.aituNet.repo;

import com.aituNet.aituNet.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Long> {
    List<Post> findByAuthorId(Integer authorId);

}
