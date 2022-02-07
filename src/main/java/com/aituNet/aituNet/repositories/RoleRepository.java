package com.aituNet.aituNet.repositories;

import com.aituNet.aituNet.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(String name);
}
