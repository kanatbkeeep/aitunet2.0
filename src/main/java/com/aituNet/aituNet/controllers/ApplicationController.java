package com.aituNet.aituNet.controllers;


import com.aituNet.aituNet.entities.Application;
import com.aituNet.aituNet.request.CancelApplication;
import com.aituNet.aituNet.request.SendToRequest;
import com.aituNet.aituNet.service.ApplicationServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/requests")
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
    public ResponseEntity ShowRequest(@RequestBody SendToRequest sendToRequest){
            return ResponseEntity.ok().body(applicationService.showApplication(sendToRequest.getSendToId()));
        }
}
