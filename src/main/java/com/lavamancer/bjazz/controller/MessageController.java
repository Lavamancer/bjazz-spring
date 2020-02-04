package com.lavamancer.bjazz.controller;

import com.lavamancer.bjazz.entity.Message;
import com.lavamancer.bjazz.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MessageController {

    @Autowired MessageService messageService;


    @PostMapping("/public/users/{userId}/messages")
    public ResponseEntity<Message> postMessage(
            @PathVariable Long userId,
            @RequestParam String body,
            @RequestParam Long receiverId
    ) {
        return ResponseEntity.status(HttpStatus.CREATED).body(messageService.create(userId, receiverId, body));
    }

    @GetMapping("/public/users/{userId}/messages")
    public ResponseEntity<List<Message>> getMessages(
            @PathVariable Long userId,
            @RequestParam Long receiverId
    ) {
        return ResponseEntity.status(HttpStatus.OK).body(messageService.findByReceiverId(userId, receiverId));
    }

}
