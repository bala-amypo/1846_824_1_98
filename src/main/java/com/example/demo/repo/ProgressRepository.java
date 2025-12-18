package com.example.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entity.Course;

public interface ProgressRepository extends JpaRepository<Progress, Long> {
}
