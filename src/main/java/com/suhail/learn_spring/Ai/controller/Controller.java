package com.suhail.learn_spring.Ai.controller;

import com.suhail.learn_spring.Ai.SERVICE.LabourService;
import com.suhail.learn_spring.Ai.dto.LabourRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/labour")
public class Controller {
    private final LabourService labourService;

    public Controller(LabourService labourService) {
        this.labourService = labourService;
    }

    @PostMapping("/recommendations")
    public ResponseEntity<String>recommended(@RequestBody LabourRequest request){
return        ResponseEntity.ok(labourService.getRecommendations(request));
    }
}
