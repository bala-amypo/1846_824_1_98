package com.example.demo.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.validation.constraints.NotBlank;
@Entity
@Table(
    name = "course",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "instructorId"})
    }
)
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    @Column(nullable = false)
    private String title;

    @Column(nullable = true)
    private String description;

    private String category;

    @NotNull
    @Column(nullable = false)
    private Long instructorId;

    private LocalDateTime createdAt;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Course() {}

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public Long getInstructorId() {
        return instructorId;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setInstructorId(Long instructorId) {
        this.instructorId = instructorId;
    }

    public Course() {
    }
    public Course(String title, String description, String category, Long instructorId) {
        this.title = title;
        this.description = description;
        this.category = category;
        this.instructorId = instructorId;
    }
}
