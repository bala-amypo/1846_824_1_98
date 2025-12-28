package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "courses")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;
    private String category;

    // ✅ Parent side for JSON
    @ManyToOne
    @JoinColumn(name = "instructor_id")
    @JsonManagedReference
    private User instructor;

    private LocalDateTime createdAt;

    // ✅ Parent side for Course → MicroLesson
    @OneToMany(mappedBy = "course", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<MicroLesson> microLessons;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }
}
