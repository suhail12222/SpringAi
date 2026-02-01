package com.suhail.learn_spring.Ai.SERVICE;

import com.suhail.learn_spring.Ai.dto.LabourRequest;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class LabourService {

private final ChatClient chatClient;

    public LabourService(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
    public String getRecommendations(LabourRequest labourRequest){
        String systemPrompt= """
                You are a professional hiring assistant for skilled and unskilled labours.
                Analyze user requirements and returns structured,practical recommendations.
                Avoid politics or irrelevant content.
                Give a answer in 2 lines.
                """;
        String userPrompt= """
                Job type:%s
                Work type:%s
                Experience Level:%s
                Budget:%s
                Location:%s
                Provide recommendations in JSON format with keys:
                requiredSkills,experience,softSkills,safetyChecks,redFlags.
                """.formatted(labourRequest.jobType(),labourRequest.workType(),labourRequest.experienceLevel(),labourRequest.duration(),labourRequest.budget(),labourRequest.location());
        return chatClient.prompt().system(systemPrompt).user(userPrompt).call().content();

    }
}
