package com.aituNet.aituNet.service;

import com.aituNet.aituNet.entities.Application;
import com.aituNet.aituNet.repo.ApplicationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@Slf4j
public class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationRepo applicationRepo;

    public ApplicationServiceImpl(ApplicationRepo applicationRepo) {
        this.applicationRepo = applicationRepo;
    }

    @Override
    public Application sendApplication(Application application) {
        log.info("Request was sent to {} by {}",application.getSendTo(),application.getSendBy());
        return applicationRepo.save(application);
    }

    @Override
    public void deleteApplication(Integer id) {
        log.info("Request was deleted");
        applicationRepo.deleteById(id.longValue());

    }

    @Override
    public List<Application> showApplication(Integer id) {
        return applicationRepo.findAllBySendTo(id);
    }

    @Override
    public Application ShowBySendByAndSendTo(Integer by, Integer to) {
        return applicationRepo.findApplicationBySendByAndSendTo(by,to);
    }


}
