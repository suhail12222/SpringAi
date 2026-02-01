package com.suhail.learn_spring.Ai.SERVICE;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.prompt.PromptTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class AymanJi {
private final ChatClient chatClient;


    public AymanJi(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    public String getReligionNames(String religion){
      return   chatClient.prompt()//use to take the user prompt
                .user("Give me the names ov "+religion)//use to take the user prompt
                .system("you are the good assistant to tell the accurate names 10 names ")//use to take the instructions how chat model should behave
                .call()//use to call and execute the chat model
                .content();//use to extract the string content from the response and return that;
    }
    public String getDuaRelated(String topic){
        String prompt= """
                you are a helper and you have to provide accurate instructions.
                The topic given by the user answer that concise and accurate way.
                Don't confuse user.
                Answer in 10 lines only.
                Answer the topic :{topic}
                
               
                """;
        PromptTemplate promptTemplate=new PromptTemplate(prompt);
      String text=  promptTemplate.render(Map.of("topic",topic));
       var response= chatClient.prompt()
                .user(text)
                .call()
                .chatClientResponse();
//        .content();
        return response.chatResponse().getResult().getOutput().getText();
    }
}
