package com.example.demo.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.service.Courseservice;
import com.example.demo.repo.CourseRepository;
import com.example.demo.
@Service
public class CourseServiceImpl implements Courseservice{
    @Autowired
    CourseRepository course;
    Course createCourse(Course course, Long instructorId){

    }
}