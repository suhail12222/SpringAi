//package com.suhail.learn_spring.Ai.SERVICE;
//
//import com.suhail.learn_spring.Ai.dto.HealthRequest;
//import org.springframework.ai.chat.client.ChatClient;
//import org.springframework.stereotype.Service;
//
//@Service
//public class HealthAiService {
//
//private final ChatClient chatClient;
//
//    public HealthAiService(ChatClient chatClient) {
//        this.chatClient = chatClient;
//    }
//
//    public String getHealthRecommendations(HealthRequest request){
//        String systemPrompt= """
//                You are a medical assistant AI for informational purposes only.
//                Do not diagnose diseases or prescribe restricted medicines.
//                prescribe restricted medicines.
//                Recommend doctor type,OTC, medicines, and tests only.
//                Return only valid JSON
//
//                """;
////        String userPrompt= """
////
////                Age:%s
////                Gender:%s
////                Symptoms:%s
////                Duration:%s
////                Severity:%s
////                Existing Conditions:%S
////                JSON schema{
////                "recommendedDoctor":string,
////                "possibleCauses":[string],
////                "suggestedMedicine":[string],
////                "recommendedTests":[string],
////                "disclaimer":string
////                """.formatted(request.age(),
////                request.gender()
////                 ,
////                request.symptoms(),
////                request.duration(),
////                request.severity(),
////                request.existingCondition()
////        );
//        String userPrompt = """
//You are a medical assistant.
//Do NOT diagnose.
//Provide general medical guidance only.
//
//User details:
//Age: %s
//Gender: %s
//Symptoms: %s
//Duration: %s
//Severity: %s
//Existing Conditions: %s
//
//Respond ONLY in valid JSON with this schema:
//{
//  "recommendedDoctor": "string",
//  "possibleCauses": ["string"],
//  "suggestedMedicine": ["string"],
//  "recommendedTests": ["string"],
//  "disclaimer": "string"
//}
//""".formatted(
//                request.age(),
//                request.gender(),
//                request.symptoms(),
//                request.duration(),
//                request.severity(),
//                request.existingCondition()
//        );
//
//        return chatClient.prompt().system(systemPrompt)
//                .user(userPrompt)
//                .call()
//                .content();
//    }
//}
