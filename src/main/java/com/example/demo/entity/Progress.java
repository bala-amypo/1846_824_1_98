package com.example.demo.entity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import java.time.LocalDateTime;
@Entity
public class Progress {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private User user;
    private String microLesson;
    private String status;
    @Min(0)
    @Max(100)
    @Column(nullable = false)
    private Integer progressPercent;

    private LocalDateTime lastAccessedAt;
    @Column(nullable = false)
    private Double score;
    
    public Long getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public MicroLesson getMicroLesson() {
        return microLesson;
    }

    public void setMicroLesson(MicroLesson microLesson) {
        this.microLesson = microLesson;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
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

    public Progress(Long id,String user,String microLesson,String status,String progressPercent,int lastAccessedAt,
    LocalDateTime date,Double score){
         this.id = id;
         this.user=user;
         this.microLesson=microLesson;
         this.status=status;
         this.progressPercent=progressPercent;
         this.lastAccessedAt=lastAccessedAt;
         this.date=date;
         this.score=score;
}
public Progress(){}
}