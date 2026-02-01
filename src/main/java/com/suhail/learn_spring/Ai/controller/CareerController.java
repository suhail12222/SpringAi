package com.suhail.learn_spring.Ai.controller;

import com.suhail.learn_spring.Ai.SERVICE.CareerAiService;
import com.suhail.learn_spring.Ai.dto.CareerRequest;
import com.suhail.learn_spring.Ai.dto.CareerResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/career")
public class CareerController {
    private final CareerAiService careerAiService;

    public CareerController(CareerAiService careerAiService) {
        this.careerAiService = careerAiService;
    }
    @PostMapping("/cons")
    public ResponseEntity<CareerResponse> getCareerConsultancy(@RequestBody CareerRequest request){
        return ResponseEntity.ok(careerAiService.generateCareerGuidance(request));
    }
}
