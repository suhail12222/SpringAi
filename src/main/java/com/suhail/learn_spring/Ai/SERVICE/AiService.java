package com.suhail.learn_spring.Ai.SERVICE;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.ai.document.Document;
import org.springframework.ai.embedding.EmbeddingModel;
import org.springframework.ai.vectorstore.SearchRequest;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
//@RequiredArgsConstructor
public class AiService {
    private final VectorStore vectorStore;
    private final ChatClient chatClient;
//    private final OpenAiApi.EmbeddingModel
    private final EmbeddingModel embeddingModel;

    public AiService(VectorStore vectorStore, ChatClient chatClient, EmbeddingModel embeddingModel) {
        this.vectorStore = vectorStore;
        this.chatClient = chatClient;
        this.embeddingModel = embeddingModel;
    }
    public float[] getEmbedding(String text){
        return embeddingModel.embed(text);
    }

//    public  String getDummyJoke(String joke){
//return
//        chatClient.
//                prompt().
//                system("you are a sarcastic joker , give response in 1 line only").
//      user("Give me a joke on the topic"+joke)
//                .call().
//                content();
//
//    }


//    public void ingestDataToVectorStore(String text){
//        Document document=new Document(text);
//        vectorStore.add(List.of(document));
//    }
    public void ingestDataVectorStore(){
        List<Document> movies = List.of(

                new Document(
                        "A mind-bending thriller about dreams within dreams.",
                        Map.of("title", "Inception", "genre", "Sci-Fi", "year", 2010)
                ),

                new Document(
                        "A computer hacker learns about the true nature of reality.",
                        Map.of("title", "The Matrix", "genre", "Sci-Fi", "year", 1999)
                ),

                new Document(
                        "A team travels through a wormhole in space to save humanity.",
                        Map.of("title", "Interstellar", "genre", "Sci-Fi", "year", 2014)
                ),

                new Document(
                        "A cyborg assassin travels back in time to kill a resistance leader.",
                        Map.of("title", "The Terminator", "genre", "Sci-Fi", "year", 1984)
                ),

                new Document(
                        "A programmer discovers his reality is a simulated world.",
                        Map.of("title", "The Matrix Reloaded", "genre", "Sci-Fi", "year", 2003)
                ),

                new Document(
                        "A linguist communicates with aliens to prevent global war.",
                        Map.of("title", "Arrival", "genre", "Sci-Fi", "year", 2016)
                ),

                new Document(
                        "A blade runner hunts rogue androids in a dystopian future.",
                        Map.of("title", "Blade Runner", "genre", "Sci-Fi", "year", 1982)
                ),

                new Document(
                        "A sequel exploring identity and humanity in a future world.",
                        Map.of("title", "Blade Runner 2049", "genre", "Sci-Fi", "year", 2017)
                ),

                new Document(
                        "A theme park suffers a catastrophic failure involving dinosaurs.",
                        Map.of("title", "Jurassic Park", "genre", "Sci-Fi", "year", 1993)
                ),

                new Document(
                        "A man relives the same day repeatedly during an alien invasion.",
                        Map.of("title", "Edge of Tomorrow", "genre", "Sci-Fi", "year", 2014)
                )
        );
        vectorStore.add(movies);
    }
    public List<Document> similaritySearch(String text){
//       return vectorStore.similaritySearch(text);
        return vectorStore.similaritySearch(SearchRequest.builder()

                        .query(text)//using the query which we wana
                        .topK(2)//for top ones
                        .similarityThreshold(0.3)//have high confidence
                .build());
    }

    //  TODO  another way the best way is
    public String getDummyJoke(String topic){
        String systemPrompt= """
                you are a sarcastic joker,you make poetic jokes in 4 lines.
                you don't make jokes about politics.
                Give me a joke on the topic :{topic}
                """;
        PromptTemplate promptTemplate=new PromptTemplate(systemPrompt);
        String renderText=promptTemplate.render(Map.of("topic",topic));
        return chatClient.prompt()
                .user(renderText)
                .call()
                .content();
    }

    public String getInfo(String topic){
        String systemPrompt= """
                you are a helpful,concise,and accurate assistant.
                Answer Clearly using simple language.
                Avoid unnecessary verbosity.
                If something is unknown ,Say you don't know.
                Give me information about topic:{topic}
                """;
        PromptTemplate promptTemplate=new PromptTemplate(systemPrompt);
        String renderText=promptTemplate.render(Map.of("topic",topic));
        var response=chatClient.prompt()
                .user(renderText)
                .call()
                .chatClientResponse();
        return  response.chatResponse().getResult().getOutput().getText();

    }

}
