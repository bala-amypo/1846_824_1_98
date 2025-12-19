package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MicroRequestDTO;
import com.example.demo.entity.Micro;
import com.example.demo.service.LessonService;
@RestController
@RequestMapping("/lessons")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/course/{courseId}")
    public Micro addLesson(
            @PathVariable Long courseId,
            @RequestBody MicroRequestDTO dto) {

        return lessonService.addLesson(courseId, dto);
    }

    @PutMapping("/{lessonId}")
    public Micro updateLesson(
            @PathVariable Long lessonId,
            @RequestBody MicroRequestDTO dto) {

        return lessonService.updateLesson(lessonId, dto);
    }

    @GetMapping("/{lessonId}")
    public Micro getLesson(@PathVariable Long lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @GetMapping("/search")
    public List<Micro> findLessons(
            @RequestParam(required = false) String tags,
            @RequestParam(required = false) String difficulty,
            @RequestParam(required = false) String contentType) {

        return lessonService.findLessonsByFilters(tags, difficulty, contentType);
    }
}
