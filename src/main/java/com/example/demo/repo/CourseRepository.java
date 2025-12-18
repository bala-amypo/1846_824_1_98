package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;

public interface CourseRepository extends JpaRepository<Course, Long> {

    boolean existsByTitleAndInstructor(String title, User instructor);

    List<Course> findByInstructor(User instructor);
}
