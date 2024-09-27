package com.chenzhehao.test.springbootnetty.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Controller
public class WebSocketController {


    @Autowired
    private SimpMessagingTemplate messagingTemplate;
    static ExecutorService execuserService = Executors.newFixedThreadPool(1);

    @MessageMapping("/send")
    @SendTo("/topic/messages")
    public String handleMessage(String message) {
        System.out.println("Received: " + message);
        //将下数代码加入异步线程中
        execuserService.submit(() -> {
            try {
                Thread.sleep(1000);
                messagingTemplate.convertAndSend("/topic/messages", message+"异步异步2");
                Thread.sleep(1000);
                messagingTemplate.convertAndSend("/testUser/topic/messages", message+"异步异步22");
                Thread.sleep(1000);
                messagingTemplate.convertAndSendToUser("testUser","/topic/messages", message+"异步异步3");
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return "Received: " + message;
    }

}

