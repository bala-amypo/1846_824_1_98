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
    @PostMapping("/{instructorId}")
    public Course createCourse(@PathVariable("instructorId") Long instructorId){
        
    }
}
