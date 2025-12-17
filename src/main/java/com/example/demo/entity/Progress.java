package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class Progress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private Long userId;

    @Column(nullable = false)
    private Long microLessonId;

    @Column(nullable = false)
    private String status;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private Integer progressPercent;

    @Column(nullable = false)
    private LocalDateTime lastAccessedAt;

    @Column(nullable = true)
    private Double score;

    @PrePersist
    @PreUpdate
    private void setLastAccessedAt() {
        this.lastAccessedAt = LocalDateTime.now();
    }

    public Progress() {
    }

    public Progress(
            Long id,
            Long userId,
            Long microLessonId,
            String status,
            Integer progressPercent,
            Double score
    ) {
        this.id = id;
        this.userId = userId;
        this.microLessonId = microLessonId;
        this.status = status;
        this.progressPercent = progressPercent;
        this.score = score;
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

    public Long getMicroLessonId() {
        return microLessonId;
    }

    public void setMicroLessonId(Long microLessonId) {
        this.microLessonId = microLessonId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
        if ("COMPLETED".equalsIgnoreCase(status)) {
            this.progressPercent = 100;
        }
    }

    public Integer getProgressPercent() {
        return progressPercent;
    }

    public void setProgressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
    }

    public LocalDateTime getLastAccessedAt() {
        return lastAccessedAt;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
