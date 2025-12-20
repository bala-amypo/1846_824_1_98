package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import com.example.demo.enums.ProgressStatus;
@Entity
public class Progress{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "micro_lesson_id", nullable = false)
    private Micro microLesson;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProgressStatus status;

    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private Integer progressPercent;

    private LocalDateTime lastAccessedAt;

    @Column(nullable = true)
    private Double score;
    public Progress() {
    }
    public Progress(
            User user,
            Micro microLesson,
            ProgressStatus status,
            Integer progressPercent,
            Double score
    ) {
        this.user = user;
        this.microLesson = microLesson;
        this.status = status;
        this.progressPercent = progressPercent;
        this.score = score;
    }

    @PrePersist
    public void prePersist() {
        this.lastAccessedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Micro getMicroLesson() {
        return microLesson;
    }

    public ProgressStatus getStatus() {
        return status;
    }

    public Integer getProgressPercent() {
        return progressPercent;
    }

    public LocalDateTime getLastAccessedAt() {
        return lastAccessedAt;
    }

    public Double getScore() {
        return score;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setMicroLesson(Micro microLesson) {
        this.microLesson = microLesson;
    }

    public void setStatus(ProgressStatus status) {
        this.status = status;
    }

    public void setProgressPercent(Integer progressPercent) {
        this.progressPercent = progressPercent;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
