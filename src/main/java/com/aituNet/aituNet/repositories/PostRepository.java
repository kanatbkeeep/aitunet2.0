package com.aituNet.aituNet.repositories;

import com.aituNet.aituNet.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;

public interface PostRepository extends JpaRepository<Post,Long> {
    Post findByDate(Date date);
    Post findByName(String name);
}
