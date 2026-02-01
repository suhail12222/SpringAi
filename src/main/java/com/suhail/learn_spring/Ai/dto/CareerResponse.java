package com.suhail.learn_spring.Ai.dto;

import java.util.List;

public record CareerResponse(String nameMeaningInsights,


                             String emotionalAssessment,
                             String suitableCareerField,
                             List<String> recommendations,
                             List<String> skillsToLearn,
                             List<String> learningSkills,
                             List<String> learningRoadMaps,
                             List<String> recommendedMentors,
                             String motivationalAdvices,
                             String disclaimer
                             ) {
}
