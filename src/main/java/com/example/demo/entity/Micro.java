package com.example.demo.entity;

import java.time.LocalDate;

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
import jakarta.validation.constraints.NotBlank;

import com.example.demo.enums.ContentType;
import com.example.demo.enums.Difficulty;

@Entity
public class Micro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "course_id", nullable = false)
    private Course course;

    @NotBlank
    @Column(nullable = false)
    private String title;

    @Min(1)
    @Max(15)
    @Column(name = "duration", nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContentType contentType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    private String tags;

    @Column(nullable = false, updatable = false)
    private LocalDate publishDate;

    @PrePersist
    public void onCreate() {
        this.publishDate = LocalDate.now();
    }

    public Long getId() { return id; }
    public Course getCourse() { return course; }
    public String getTitle() { return title; }
    public Integer getDurationMinutes() { return durationMinutes; }
    public ContentType getContentType() { return contentType; }
    public Difficulty getDifficulty() { return difficulty; }
    public String getTags() { return tags; }
    public LocalDate getPublishDate() { return publishDate; }

    public void setCourse(Course course) { this.course = course; }
    public void setTitle(String title) { this.title = title; }
    public void setDurationMinutes(Integer durationMinutes) { this.durationMinutes = durationMinutes; }
    public void setContentType(ContentType contentType) { this.contentType = contentType; }
    public void setDifficulty(Difficulty difficulty) { this.difficulty = difficulty; }
    public void setTags(String tags) { this.tags = tags; }
}
