package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Post;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface PostService {
    Post savePost(Post post);
    void updatePost(Integer id, String text);
    void deletePost(Integer id);
    List<Post> findByAuthorId(Integer id);
}
