package com.example.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;

import java.time.LocalDateTime;

@Entity
public class Micro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @NotBlank
    @Column(nullable = false)
    private String difficulty;

    @NotBlank
    @Column(nullable = false)
    private String contentType;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    private String tags;

    @Min(1)
    @Max(15)
    @Column(nullable = false)
    private int duration;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Micro() {
    }
    public Micro(String title,
                 String difficulty,
                 String contentType,
                 Course course,
                 String tags,
                 int duration) {

        this.title = title;
        this.difficulty = difficulty;
        this.contentType = contentType;
        this.course = course;
        this.tags = tags;
        this.duration = duration;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDifficulty() {
        return difficulty;
    }

    public String getContentType() {
        return contentType;
    }

    public Course getCourse() {
        return course;
    }

    public String getTags() {
        return tags;
    }

    public int getDuration() {
        return duration;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDifficulty(String difficulty) {
        this.difficulty = difficulty;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
