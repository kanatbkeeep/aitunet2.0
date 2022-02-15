package com.aituNet.aituNet.controllers;


import com.aituNet.aituNet.entities.Post;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class NewPostController {

    @MessageMapping("/post.send")
    @SendTo("/topic/public")
    public Post sendPost(@Payload final Post post) {
        return post;
    }



}
