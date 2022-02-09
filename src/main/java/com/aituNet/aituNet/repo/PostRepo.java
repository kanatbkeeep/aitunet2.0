package com.aituNet.aituNet.repo;

import com.aituNet.aituNet.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepo extends JpaRepository<Post, Long> {
    Post findByAuthor(String name);
}
