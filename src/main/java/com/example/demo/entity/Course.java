package com.example.demo.entity;
import java.time.LocalDateTime;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.validation.constraints.NotNull;
package com.example.demo.entity;

import jakarta.validation.constraints.NotBlank;


@Entity
@Table(
    name = "course",
    uniqueConstraints = {
        @UniqueConstraint(columnNames = {"title", "instructor_id"})
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

    private LocalDateTime createdAt;

    @ManyToOne(optional = false)
    @JoinColumn(name = "instructor_id", nullable = false)
    private User instructor;

    @PrePersist
    public void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    public Course() {
    }
    public Course(String title,
                  String description,
                  String category,
                  User instructor,
                  LocalDateTime createdAt) {

        this.title = title;
        this.description = description;
        this.category = category;
        this.instructor = instructor;
        this.createdAt = createdAt;
    }

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

    public User getInstructor() {
        return instructor;
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

    public void setInstructor(User instructor) {
        this.instructor = instructor;
    }
}
