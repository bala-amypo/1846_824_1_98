package com.example.demo.service.impl;

import com.example.demo.model.Course;
import com.example.demo.model.User;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.CourseService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {

    private final CourseRepository courseRepo;
    private final UserRepository userRepo;

    public CourseServiceImpl(CourseRepository courseRepo,
                             UserRepository userRepo) {
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Course createCourse(Course course, Long instructorId) {

        // 1️⃣ Instructor must exist
        User instructor = userRepo.findById(instructorId)
                .orElseThrow(() -> new RuntimeException("Instructor not found"));

        // 2️⃣ Role must be INSTRUCTOR
        if (!"INSTRUCTOR".equals(instructor.getRole())) {
            throw new RuntimeException("User is not an instructor");
        }

        // 3️⃣ Duplicate title check
        if (courseRepo.existsByTitleAndInstructorId(course.getTitle(), instructorId)) {
            throw new RuntimeException("Course title already exists");
        }

        course.setInstructor(instructor);
        return courseRepo.save(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));
    }

    @Override
    public Course updateCourse(Long courseId, Course updatedCourse) {

        Course existing = getCourseById(courseId);

        existing.setTitle(updatedCourse.getTitle());
        existing.setDescription(updatedCourse.getDescription());
        existing.setCategory(updatedCourse.getCategory());

        return courseRepo.save(existing);
    }

    @Override
    public List<Course> listCoursesByInstructor(Long instructorId) {
        return courseRepo.findByInstructor_Id(instructorId);
    }
}
