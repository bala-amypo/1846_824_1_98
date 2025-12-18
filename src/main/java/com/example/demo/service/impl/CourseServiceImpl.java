package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.Courseservice;
import com.example.demo.repo.CourseRepository;
import com.example.demo.entity.Course;
@Service
public class CourseServiceImpl implements Courseservice {

    @Autowired
    private CourseRepository courseRepository;

    @Override
    public Course createCourse(Course course, Long instructorId) {
        return courseRepository.save(course);
    }
}
