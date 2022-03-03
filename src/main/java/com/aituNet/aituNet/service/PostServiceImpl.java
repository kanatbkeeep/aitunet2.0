package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Post;
import com.aituNet.aituNet.repo.PostRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class PostServiceImpl implements PostService{
    private final PostRepo postRepo;

    public PostServiceImpl(PostRepo postRepo) {
        this.postRepo = postRepo;
    }

    @Override
    public Post savePost(Post post) {
        log.info("Post was added by {}", post.getAuthorId());
        return postRepo.save(post);
    }

    @Override
    public void updatePost(Integer id, String text) {
        Post post = postRepo.findById(id.longValue()).orElse(null);
        log.info("Post was updated by {}", post.getAuthorId());
        post.setTextOfPost(text);
    }

    @Override
    public void deletePost(Integer id) {
        Post post = postRepo.findById(id.longValue()).orElse(null);
        log.info("Post was deleted");
        postRepo.delete(post);
    }

    @Override
    public List<Post> findByAuthorId(Integer id) {
        return postRepo.findByAuthorId(id);
    }

    @Override
    public List<Post> findAll() {
        return postRepo.findAllByOrderByIdAsc();
    }

    @Override
    public Post findPostById(Integer postId) {
        return postRepo.findById(postId.longValue()).orElse(null);
    }
}
