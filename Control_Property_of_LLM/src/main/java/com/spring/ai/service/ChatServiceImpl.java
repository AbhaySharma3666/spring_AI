package com.spring.ai.service;

import com.spring.ai.entity.Tut;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.ollama.api.OllamaChatOptions;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ChatServiceImpl implements ChatService{

    private ChatClient chatClient;

    public ChatServiceImpl(ChatClient.Builder builder) {

        this.chatClient = builder
                .defaultOptions(OllamaChatOptions.builder()
                        .model("codellama:latest")
                        .temperature(0.3)
                        .build())
                .build();
    }

    @Override
    public String chat(String query) {

        String prompt = "tell me about file structure of spring";
        // call the llm for response
//        Prompt prompt1 = new Prompt(prompt);
//        Prompt prompt1 = new Prompt(query, OllamaChatOptions.builder()
//                .model("codellama:latest")
//                .temperature(0.3)
//                .ma
//                .build()
//        );

        Prompt prompt1 = new Prompt(prompt);
        var metadata = chatClient
                .prompt(prompt1)
                .call()
                .chatResponse()
                .getMetadata();

        System.out.println(metadata);


        var tutorials = chatClient
                .prompt(query)
                .call()
                .content();

        return tutorials;
    }
}
