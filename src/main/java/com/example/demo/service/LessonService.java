package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.Micro;

public interface LessonService {

    Micro addLesson(Long courseId, Micro lesson);

    Micro updateLesson(Long lessonId, Micro lesson);

    List<Micro> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType
    );

    Micro getLesson(Long lessonId);
}
