package com.example.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.Courseservice;
import com.example.demo.repo.CourseRepository;
import com.example.demo.entity.Course;
@Service
public class CourseServiceImpl implements Courseservice {

    @Autowired
    private CourseRepository course1;

    @Override
    public Course createCourse(Course course, Long instructorId) {
        return course1.save(course);
    }
    @Override
    public Course updateCourse(Long courseId, Course course){
        course exist=getCourseById(courseId);
        exist.setCourse(course.get());
        return course1.save(exist);
    }
}
