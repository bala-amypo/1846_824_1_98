package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.repo.CourseRepository;
import com.example.demo.service.Courseservice;

@Service
public class CourseServiceImpl implements Courseservice {

    @Autowired
    private CourseRepository course1;

    @Override
    public Course createCourse(Course course, Long instructorId) {
        course.setInstructorId(instructorId);
        return course1.save(course);
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course exist = getCourse(courseId);

        if (exist != null) {
            exist.setTitle(course.getTitle());
            exist.setDescription(course.getDescription());
            exist.setCategory(course.getCategory());
            return course1.save(exist);
        }
        return null;
    }

    @Override
    public void deleteCourse(Long courseId) {
        Course exist = getCourse(courseId);
        if (exist != null) {
            course1.delete(exist);
        }
    }

    @Override
    public List<Course> listCoursesByInstructor(Long instructorId) {
        return course1.findByInstructorId(instructorId);
    }

    @Override
    public Course getCourse(Long courseId) {
        return course1.findById(courseId).orElse(null);
    }

    @Override
    public List<Course> getAllCourses() {
        return course1.findAll();
    }
}
