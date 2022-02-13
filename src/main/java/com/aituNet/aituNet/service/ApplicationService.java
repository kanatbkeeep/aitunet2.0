package com.aituNet.aituNet.service;


import com.aituNet.aituNet.entities.Application;
import com.aituNet.aituNet.entities.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ApplicationService {

    Application sendApplication(Application application);
    void deleteApplication(Integer id);
    List<Application> showApplication(Integer id);
}
