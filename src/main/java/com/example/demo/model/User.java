package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "users")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true, nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    private String role;
    private String preferredLearningStyle;
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "instructor")
    @JsonBackReference   
    private List<Course> courses;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference 
    private List<Progress> progressList;

    @OneToMany(mappedBy = "user")
    @JsonManagedReference   
    private List<Recommendation> recommendations;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
        if (this.role == null) {
            this.role = "LEARNER";
        }
    }
}
