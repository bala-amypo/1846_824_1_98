package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Recommendation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Column(nullable = false)
    private LocalDateTime generatedAt;

    @Column(nullable = false, length = 1000)
    private String recommendedLessonIds;

    @Column(nullable = false)
    private String basisSnapshot;

    @Min(0)
    @Max(1)
    @Column(nullable = false)
    private Double confidenceScore;

    @PrePersist
    public void onCreate() {
        this.generatedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }

    public String getRecommendedLessonIds() {
        return recommendedLessonIds;
    }

    public String getBasisSnapshot() {
        return basisSnapshot;
    }

    public Double getConfidenceScore() {
        return confidenceScore;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setRecommendedLessonIds(String recommendedLessonIds) {
        this.recommendedLessonIds = recommendedLessonIds;
    }

    public void setBasisSnapshot(String basisSnapshot) {
        this.basisSnapshot = basisSnapshot;
    }

    public void setConfidenceScore(Double confidenceScore) {
        this.confidenceScore = confidenceScore;
    }
}
