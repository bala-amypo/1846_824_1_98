package com.example.demo.controller;

import com.example.demo.dto.CourseRequest;
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

    @PostMapping(
            value = "/{instructorId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course create(@PathVariable Long instructorId,
                         @RequestBody CourseRequest request) {

        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setCategory(request.getCategory());

        return service.createCourse(course, instructorId);
    }

    @PutMapping(
            value = "/{courseId}",
            consumes = MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course update(@PathVariable Long courseId,
                         @RequestBody CourseRequest request) {

        Course course = new Course();
        course.setTitle(request.getTitle());
        course.setDescription(request.getDescription());
        course.setCategory(request.getCategory());

        return service.updateCourse(courseId, course);
    }

    @GetMapping(
            value = "/{courseId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public Course get(@PathVariable Long courseId) {
        return service.getCourse(courseId);
    }

    @GetMapping(
            value = "/instructor/{instructorId}",
            produces = MediaType.APPLICATION_JSON_VALUE
    )
    public List<Course> list(@PathVariable Long instructorId) {
        return service.listCoursesByInstructor(instructorId);
    }
}
