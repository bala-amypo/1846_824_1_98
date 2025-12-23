package com.example.demo.service.impl;

import com.example.demo.exception.ResourceNotFoundException;
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

    public CourseServiceImpl(CourseRepository courseRepo, UserRepository userRepo) {
        this.courseRepo = courseRepo;
        this.userRepo = userRepo;
    }

    @Override
    public Course createCourse(Course course, Long instructorId) {
        User instructor = userRepo.findById(instructorId)
                .orElseThrow(() -> new ResourceNotFoundException("Instructor not found"));

        if (!instructor.getRole().equals("INSTRUCTOR") &&
            !instructor.getRole().equals("ADMIN")) {
            throw new IllegalArgumentException("Only INSTRUCTOR or ADMIN can create courses");
        }

        if (courseRepo.existsByTitleAndInstructorId(course.getTitle(), instructorId)) {
            throw new IllegalArgumentException("Course title already exists for this instructor");
        }

        course.setInstructor(instructor);
        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course existing = getCourse(courseId);
        existing.setTitle(course.getTitle());
        existing.setDescription(course.getDescription());
        existing.setCategory(course.getCategory());
        return courseRepo.save(existing);
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepo.findById(courseId)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    @Override
    public List<Course> listCoursesByInstructor(Long instructorId) {
        return courseRepo.findByInstructor_Id(instructorId);
    }
}
