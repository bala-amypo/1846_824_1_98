package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private LocalDateTime generatedAt;

    @Column(nullable = false, length = 1000)
    private String recommendedLessons;

    @Column(nullable = false, length = 1000)
    private String basisSnapshot;

    @DecimalMin(value = "0.0")
    @DecimalMax(value = "1.0")
    @Column(nullable = false)
    private Double confidenceScore;

    @PrePersist
    private void setGeneratedAt() {
        this.generatedAt = LocalDateTime.now();
    }

    public Recommendation() {
    }

    public Recommendation(
            Long id,
            Long userId,
            String recommendedLessons,
            String basisSnapshot,
            Double confidenceScore
    ) {
        this.id = id;
        this.userId = userId;
        this.recommendedLessons = recommendedLessons;
        this.basisSnapshot = basisSnapshot;
        this.confidenceScore = confidenceScore;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public String getRecommendedLessons() {
        return recommendedLessons;
    }

    public void setRecommendedLessons(String recommendedLessons) {
        this.recommendedLessons = recommendedLessons;
    }

    public String getBasisSnapshot() {
        return basisSnapshot;
    }

    public void setBasisSnapshot(String basisSnapshot) {
        this.basisSnapshot = basisSnapshot;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
}
