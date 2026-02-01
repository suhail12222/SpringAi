package com.suhail.learn_spring.Ai.SERVICE;

import lombok.RequiredArgsConstructor;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AiServicess {

    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;
public float[]getEmbedding(String text){
    return embeddingModel.embed(text);//array of float means converting text into numeric values
}

}
