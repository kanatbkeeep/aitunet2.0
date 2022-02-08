package com.aituNet.aituNet.repo;

import com.aituNet.aituNet.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
