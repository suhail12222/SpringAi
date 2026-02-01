package com.suhail.learn_spring.Ai.SERVICE;

import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.core.io.Resource;
//import jakarta.annotation.Resource;
//import lombok.Value;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.client.advisor.SimpleLoggerAdvisor;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
//import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
public class RagService {
    private final ChatClient chatClient;
//    private final VectorStore vectorStore;
    private final EmbeddingModel embeddingModel;
    private final VectorStore vectorStore;


@Value("classpath:The_Mechanics_of_Generative_AI_542776d945.pdf")
Resource pdfFile;

    public RagService(ChatClient chatClient, EmbeddingModel embeddingModel, VectorStore vectorStore) {
        this.chatClient = chatClient;
        this.embeddingModel = embeddingModel;
        this.vectorStore = vectorStore;
    }

    public  String askAi(String prompt){

        String template= """
                You are an ai assistant helping a developer.
                Rules:
                -Use Only provided in the context.
                -You may rephrase,Summarize,and explain in natural language.
                -Do Not introduce new concepts or facts.
                -If multiple content sections are relevant,combine then into a single explanation
                -If the answer is not present,say "I don't know"
                Context :
                {context}
                Answer in a friendly, Conversational tone.
                """;
        List<Document>documents=vectorStore.similaritySearch(SearchRequest.builder()

                        .query(prompt)
                        .topK(2)
//                        .similarityThreshold("topic=='ai' or topic =='vectorstore")
                        .similarityThreshold(0.5)
                        .filterExpression("file_name=='The_Mechanics_of_Generative_AI_542776d945.pdf'")

                .build());
        String context= documents.stream()
                .map(Document::getText)
                .collect(Collectors.joining("\n\n"));
        PromptTemplate promptTemplate=new PromptTemplate(template);
        String systemPrompt=promptTemplate.render(Map.of("context",context));
   return chatClient.prompt()
           .system(systemPrompt)
           .user(prompt)
           .advisors(new SimpleLoggerAdvisor())
           .call()
           .content();
    }
    public void ingestPdfVectorStore(){
//        org.springframework.core.io.Resource pdf=new ClassPathResource("The_Mechanics_of_Generative_AI_542776d945.pdf");
        PagePdfDocumentReader reader=new PagePdfDocumentReader(pdfFile);
        List<Document> pages=reader.get();
        TokenTextSplitter tokenTextSplitter= TokenTextSplitter.builder()


                .withChunkSize(200)
//                .withMaxNumChunks()
                .build();
      List<Document>chunks=  tokenTextSplitter.apply(pages);
vectorStore.add(chunks);
    }
}
