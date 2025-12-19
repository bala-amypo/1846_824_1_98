package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.dto.MicroRequestDTO;
import com.example.demo.entity.Micro;
import com.example.demo.service.LessonService;

@RestController
@RequestMapping("/lesson")
public class LessonController {

    @Autowired
    private LessonService lessonService;

    @PostMapping("/add/{courseId}")
    public Micro addLesson(
            @PathVariable Long courseId,
            @RequestBody MicroRequestDTO dto) {

        return lessonService.addLesson(courseId, dto);
    }

    @PutMapping("/update/{lessonId}")
    public Micro updateLesson(
            @PathVariable Long lessonId,
            @RequestBody MicroRequestDTO dto) {

        return lessonService.updateLesson(lessonId, dto);
    }

    @GetMapping("/get/{lessonId}")
    public Micro getLesson(@PathVariable Long lessonId) {
        return lessonService.getLesson(lessonId);
    }

    @GetMapping("/filter")
    public List<Micro> findLessons(
            @RequestParam String tags,
            @RequestParam String difficulty,
            @RequestParam String contentType) {

        return lessonService.findLessonsByFilters(tags, difficulty, contentType);
    }
}
