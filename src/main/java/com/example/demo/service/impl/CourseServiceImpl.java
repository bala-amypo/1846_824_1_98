package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.User;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.UserRepository;
import com.example.demo.service.Courseservice;

@Service
public class CourseServiceImpl implements Courseservice {

    @Autowired
    private CourseRepository courseRepo;

    @Autowired
    private UserRepository userRepo;

    @Override
    public Course createCourse(Course course, Long instructorId) {

        User instructor = userRepo.findById(instructorId).orElse(null);
        course.setInstructor(instructor);

        return courseRepo.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {

        Course existing = getCourse(courseId);
        if (existing != null) {
            existing.setTitle(course.getTitle());
            existing.setDescription(course.getDescription());
            existing.setCategory(course.getCategory());
            return courseRepo.save(existing);
        }
        return null;
    }

    @Override
    public List<Course> listCoursesByInstructor(Long instructorId) {
        return courseRepo.findByInstructor_Id(instructorId);
    }

    @Override
    public Course getCourse(Long courseId) {
        return courseRepo.findById(courseId).orElse(null);
    }
}
