package com.aituNet.aituNet;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class PostServiceImpl implements PostService {
    @Autowired
    private final PostRepository postRepo;

    @Override
    public Post savePost(Post post) {
        log.info("Saving new post {} to the database", post.getText());
        return postRepo.save(post);
    }

    @Override
    public void updatePost(String text, String name) {
        Post post = postRepo.findByName(name);
        post.setText(text);
        postRepo.save(post);
    }

    @Override
    public boolean deletePost(PostRequest postRequest) {
        Post post = postRepo.findByName(postRequest.getName());
        if (post == null) {
            return false;
        }
        postRepo.delete(post);
        return true;
    }

    @Override
    public Post getPostByName(String name) {
        return postRepo.findByName(name);
    }


    @Override
    public List<Post> getPosts() {
        log.info("All Posts:");
        return postRepo.findAll();
    }

    @Override
    public Post getPostByDate(Date date) {
        return postRepo.findByDate(date);
    }

}

