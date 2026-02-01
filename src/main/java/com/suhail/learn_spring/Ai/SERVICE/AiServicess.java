package com.suhail.learn_spring.Ai.SERVICE;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;

//import javax.swing.event.DocumentListener;
//import javax.swing.event.UndoableEditListener;
//import javax.swing.text.*;

@Service
//@RequiredArgsConstructor
public class AiServicess {
private final VectorStore vectorStore;
    private final ChatClient chatClient;
    private final EmbeddingModel embeddingModel;

    public AiServicess(VectorStore vectorStore, ChatClient chatClient, EmbeddingModel embeddingModel) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClient;
        this.embeddingModel = embeddingModel;
    }
    public void ingestDataToVectorStore(String text){
      //TODO to store text into vectorStore we have to convert it into the Document object first
      Document document=new Document(text) ;
      //TODO pass to the vector store
      vectorStore.add(List.of(document));
  }


    public float[]getEmbedding(String text){
    return embeddingModel.embed(text);//array of float means converting text into numeric values
}

}
