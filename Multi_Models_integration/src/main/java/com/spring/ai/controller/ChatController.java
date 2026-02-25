package com.spring.ai.controller;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
public class ChatController {

    private ChatClient openAiChatClient;
    private ChatClient ollamaChatClient;

    public ChatController(
            @Qualifier("openAiChatClient") ChatClient openAiChatClient ,
            @Qualifier("ollamaChatClient") ChatClient ollamaChatClient
    ) {
        this.openAiChatClient = openAiChatClient;
        this.ollamaChatClient = ollamaChatClient;
    }


    @GetMapping("/chat")
    public ResponseEntity<String> chat(
            @RequestParam(value = "q") String q) {

        var resultResponse = this.ollamaChatClient
                .prompt()
                .user(q)
                .call()
                .content();

        return ResponseEntity.ok(resultResponse);
    }
}