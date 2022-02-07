package com.aituNet.aituNet.services;

import com.aituNet.aituNet.entity.Post;
import com.aituNet.aituNet.requests.PostRequest;

import java.util.Date;
import java.util.List;

public interface PostService {

    Post savePost(Post post);
    void updatePost(String text, String name);
    boolean deletePost(PostRequest postRequest);
    Post getPostByName(String name);
    List<Post> getPosts();
    Post getPostByDate(Date date);
}
