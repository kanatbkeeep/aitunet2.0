package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostService {
    Post savePost(Post post);
    void updatePost(Integer id, String text);
    void deletePost(Integer id);
}
