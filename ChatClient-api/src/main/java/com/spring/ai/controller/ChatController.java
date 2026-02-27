package com.spring.ai.controller;

import com.spring.ai.entity.Tut;
import com.spring.ai.service.ChatService;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
public class ChatController {

//    private ChatClient chatClient;

    private ChatService chatService;

//    private ChatClient openAiChatClient;
//    private ChatClient ollamaChatClient;

//    public ChatController(
//            @Qualifier("openAiChatClient") ChatClient openAiChatClient ,
//            @Qualifier("ollamaChatClient") ChatClient ollamaChatClient
//    ) {
//        this.openAiChatClient = openAiChatClient;
//        this.ollamaChatClient = ollamaChatClient;
//    }

//    public ChatController(ChatClient.Builder chatClientBuilder) {
//        this.chatClient = chatClientBuilder.build();
//    }


    public ChatController(ChatService chatService) {
        this.chatService = chatService;
    }

    @GetMapping("/chat")
    public ResponseEntity<List<Tut>> chat(
            @RequestParam(value = "q") String q) {

        return ResponseEntity.ok(chatService.chat(q));
    }
}