package com.example.demo.controller;

import com.example.demo.model.Course;
import com.example.demo.service.CourseService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService service;

    public CourseController(CourseService service) {
        this.service = service;
    }

    // CREATE COURSE
    @PostMapping(
        value = "/{instructorId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course createCourse(
            @PathVariable Long instructorId,
            @RequestBody Course course
    ) {
        return service.createCourse(instructorId, course);
    }

    // GET COURSE BY ID
    @GetMapping("/{courseId}")
    public Course getCourse(@PathVariable Long courseId) {
        return service.getCourseById(courseId);
    }

    // UPDATE COURSE
    @PutMapping(
        value = "/{courseId}",
        consumes = MediaType.APPLICATION_JSON_VALUE,
        produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course updateCourse(
            @PathVariable Long courseId,
            @RequestBody Course course
    ) {
        return service.updateCourse(courseId, course);
    }

    // GET COURSES BY INSTRUCTOR
    @GetMapping("/instructor/{instructorId}")
    public List<Course> getCoursesByInstructor(
            @PathVariable Long instructorId
    ) {
        return service.listCoursesByInstructor(instructorId);
    }
}
