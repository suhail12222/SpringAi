package com.suhail.learn_spring.Ai.config;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiConfig {

    @Bean
    public ChatClient chatClient(ChatClient.Builder builder)
    {
return builder.build();
    }
//TODO WE CAN CONFIGURE A LOT OF SYSTEMS LIKE DEFAULT SYSTEM PROMPT DEFAULT TOOLS HERE

}
