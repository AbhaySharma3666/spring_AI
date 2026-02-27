package com.spring.ai.service;

import com.spring.ai.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder chatClientBuilder) {
        this.chatClient = chatClientBuilder.build();
    }

    @Override
    public List<Tut> chat(String query) {
//        String prompt = "tell me about file structure of spring";
//        // call the llm for response
//        String content = chatClient
//                .prompt()
//                .user(prompt)
//                .system("As a java developer expert")
//                .call()
//                .content();

        String prompt = "tell me about file structure of spring";
        // call the llm for response
//        Prompt prompt1 = new Prompt(prompt);
        Prompt prompt1 = new Prompt(query);
        var metadata = chatClient
                .prompt(prompt1)
                .call()
                .chatResponse()
                .getMetadata();

        System.out.println(metadata);


        List<Tut> tutorial = chatClient
                .prompt(prompt1)
                .call()
                .entity(new ParameterizedTypeReference<List<Tut>>() {
                });

        return tutorial;
    }
}
