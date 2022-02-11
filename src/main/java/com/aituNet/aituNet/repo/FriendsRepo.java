package com.aituNet.aituNet.repo;


import com.aituNet.aituNet.entities.Friends;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FriendsRepo extends JpaRepository<Friends, Long> {

    List<Friends> findAllById(Integer id);
}
