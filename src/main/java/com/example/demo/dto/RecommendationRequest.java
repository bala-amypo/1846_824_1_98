package com.example.demo.dto;

public class RecommendationRequest {

    private String basisSnapshot;
    private String recommendedLessonIds;
    private Double confidenceScore;

    public String getBasisSnapshot() {
        return basisSnapshot;
    }

    public void setBasisSnapshot(String basisSnapshot) {
        this.basisSnapshot = basisSnapshot;
    }

    public String getRecommendedLessonIds() {
        return recommendedLessonIds;
    }

    public void setRecommendedLessonIds(String recommendedLessonIds) {
        this.recommendedLessonIds = recommendedLessonIds;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
}
