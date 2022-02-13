package com.aituNet.aituNet.controllers;


import com.aituNet.aituNet.entities.Application;
import com.aituNet.aituNet.request.CancelApplication;
import com.aituNet.aituNet.request.SendToRequest;
import com.aituNet.aituNet.service.ApplicationServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/requests")
@Slf4j
public class ApplicationController {

    private final ApplicationServiceImpl applicationService;

    @PostMapping("/send")
        public ResponseEntity SendRequest (@RequestBody Application application){
        applicationService.sendApplication(application);
            return new ResponseEntity("request created", HttpStatus.CREATED);
        }
        @PostMapping("/cancel")
    public  ResponseEntity CancelRequest(@RequestBody CancelApplication cancelApplication){
        applicationService.deleteApplication(cancelApplication.getRequest_id());
            return new ResponseEntity("request is deleted", HttpStatus.CREATED);
        }
        @GetMapping("/show")
    public ResponseEntity ShowRequest(@RequestParam Integer sendToId){
            log.info(sendToId.toString());
            return ResponseEntity.ok().body(applicationService.showApplication(sendToId));
        }
}
