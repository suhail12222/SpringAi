package com.suhail.learn_spring.Ai.SERVICE;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class AiServicessTest {
    @Autowired
    public AiServicess aiServicess;
    @Test
    public void testAiEmbeddings(){
      var embeddings=  aiServicess.getEmbedding("my name is suhail");
    for (float e:embeddings){
        System.out.print(e+" ");
    }
    }


}