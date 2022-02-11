package com.aituNet.aituNet.repo;


import com.aituNet.aituNet.entities.Application;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ApplicationRepo extends JpaRepository<Application, Long> {
    List<Application> findAllById(Integer id);
}
