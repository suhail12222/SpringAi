package com.suhail.learn_spring.Ai.controller;

//import com.suhail.learn_spring.Ai.SERVICE.HealthAiService;
import com.suhail.learn_spring.Ai.dto.HealthRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/health")
public class HealthController {
//    private final HealthAiService healthAiService;
//
//    public HealthController(HealthAiService healthAiService) {
//        this.healthAiService = healthAiService;
//    }
//    @PostMapping("/recom")
//    public ResponseEntity< String> getRecommendation(@RequestBody HealthRequest request){
//        return ResponseEntity.ok(healthAiService.getHealthRecommendations(request));
//    }
}
