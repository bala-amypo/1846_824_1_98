package com.example.demo.service;

import java.util.List;

import com.example.demo.dto.MicroRequestDTO;
import com.example.demo.entity.Micro;

public interface LessonService {

    Micro addLesson(Long courseId, MicroRequestDTO dto);

    Micro updateLesson(Long lessonId, MicroRequestDTO dto);

    Micro getLesson(Long lessonId);

    List<Micro> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType
    );
}
