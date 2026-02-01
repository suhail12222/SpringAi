package com.suhail.learn_spring.Ai.SERVICE;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.suhail.learn_spring.Ai.dto.CareerRequest;
import com.suhail.learn_spring.Ai.dto.CareerResponse;
import org.springframework.ai.chat.client.ChatClient;
import org.springframework.stereotype.Service;

@Service
public class CareerAiService {
private final ChatClient chatClient;
private final ObjectMapper objectMapper;

    public CareerAiService(ChatClient chatClient, ObjectMapper objectMapper) {
        this.chatClient = chatClient;
        this.objectMapper = objectMapper;
    }

    public CareerResponse generateCareerGuidance(CareerRequest request){
        String systemPrompt= """
                You are a professional AI Career Counselor and Life Guidance Assistant.

    Rules:
            - Be realistic and ethical
- No astrology or predictions
- No guaranteed success claims
- Focus on skills, psychology, and career paths
- Output MUST be valid JSON
                """;
        String userPrompt= """
                User Details:
                Name: %s
                Age: %d
                Current Feeling: %s
                Current Situation: %s
                Interests: %s
                Strengths: %s
                Weaknesses: %s
                Dream Role: %s
                Time Horizon: %s
                                
                Return JSON strictly in this schema:
                {
                  "nameMeaningInsight": "string",
                  "emotionalAssessment": "string",
                  "suitableCareerField": "string",
                  "recommendedRoles": ["string"],
                  "skillsToLearn": ["string"],
                  "learningRoadmap": ["string"],
                  "recommendedMentors": ["string"],
                  "motivationalAdvice": "string",
                  "disclaimer": "string"
                }
                """.formatted(request.name(),
                request.age(),
                request.currentFeeling(),
                request.currentSituation(),
                request.interests(),
                request.strengths(),
                request.weaknesses(),
                request.dreamRole(),
                request.timeHorizon());
    String aiResponse=chatClient.prompt().system(systemPrompt).user(userPrompt).call().content();
    try{
        return objectMapper.readValue(aiResponse,CareerResponse.class);
    }catch (Exception e){
        throw new RuntimeException("failed to parse Ai response",e);
    }
    }



}
