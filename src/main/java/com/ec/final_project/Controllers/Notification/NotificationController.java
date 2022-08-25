package com.ec.final_project.Controllers.Notification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Notification")
@CrossOrigin("*")
public class NotificationController {

    @Autowired
    private SimpMessagingTemplate simpMessagingTemplate;

    @MessageMapping("/message")
    @SendTo("/chatroom/public")
    public String receiveMessage(@Payload String message){
        System.out.println(message);
        return message;
    }

    @MessageMapping("/private-message")
    public String recMessage(@Payload String message){
        simpMessagingTemplate.convertAndSendToUser(message,"/private",message);
        System.out.println(message.toString());
        return message;
    }
}
