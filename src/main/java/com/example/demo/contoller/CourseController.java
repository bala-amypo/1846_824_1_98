package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.demo.dto.CourseRequestDTO;
import com.example.demo.entity.Course;
import com.example.demo.service.Courseservice;

@RestController
@RequestMapping("/courses")
public class CourseController {
     @Autowired
    private Courseservice courseService;

   
    @PostMapping("/{instructorId}")
    public Course createCourse(
            @Valid @RequestBody CourseRequestDTO dto,
            @PathVariable("instructorId") Long instructorId) {

        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setCategory(dto.getCategory());

        return courseService.createCourse(course, instructorId);
    }

   
    @PutMapping("/{courseId}")
    public Course updateCourse(
            @PathVariable("courseId") Long courseId,
            @Valid @RequestBody CourseRequestDTO dto) {

        Course course = new Course();
        course.setTitle(dto.getTitle());
        course.setDescription(dto.getDescription());
        course.setCategory(dto.getCategory());

        return courseService.updateCourse(courseId, course);
    }

    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable("courseId") Long courseId) {
        return courseService.getCourse(courseId);
    }

    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(
            @PathVariable("instructorId") Long instructorId) {
        return courseService.listCoursesByInstructor(instructorId);
        }
}
