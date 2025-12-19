package com.example.demo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

enum ContentType {
    VIDEO,
    ARTICLE,
    QUIZ,
    AUDIO
}

enum Difficulty {
    BEGINNER,
    INTERMEDIATE,
    ADVANCED
}

@Entity
public class Micro{

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
    @Column(nullable = false)
    private Integer durationMinutes;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ContentType contentType;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Difficulty difficulty;

    private String tags;

    @Column(nullable = false)
    private LocalDate publishDate;

    @PrePersist
    public void onCreate() {
        this.publishDate = LocalDate.now();
    }

    public Micro() {}

    public Long getId() {
        return id;
    }

    public Course getCourse() {
        return course;
    }

    public String getTitle() {
        return title;
    }

    public Integer getDurationMinutes() {
        return durationMinutes;
    }

    public ContentType getContentType() {
        return contentType;
    }

    public Difficulty getDifficulty() {
        return difficulty;
    }

    public String getTags() {
        return tags;
    }

    public LocalDate getPublishDate() {
        return publishDate;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDurationMinutes(Integer durationMinutes) {
        this.durationMinutes = durationMinutes;
    }

    public void setContentType(ContentType contentType) {
        this.contentType = contentType;
    }

    public void setDifficulty(Difficulty difficulty) {
        this.difficulty = difficulty;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }
}
