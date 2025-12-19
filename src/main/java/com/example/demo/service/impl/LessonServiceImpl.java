package com.example.demo.service.impl;

import com.example.demo.entity.Course;
import com.example.demo.entity.MicroLesson;
import com.example.demo.enums.ContentType;
import com.example.demo.enums.Difficulty;
import com.example.demo.repository.CourseRepository;
import com.example.demo.repository.MicroLessonRepository;
import com.example.demo.service.LessonService;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LessonServiceImpl implements LessonService {

    private final MicroLessonRepository lessonRepo;
    private final CourseRepository courseRepo;

    public LessonServiceImpl(MicroLessonRepository lessonRepo,
                             CourseRepository courseRepo) {
        this.lessonRepo = lessonRepo;
        this.courseRepo = courseRepo;
    }

    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {
        Course course = courseRepo.findById(courseId)
                .orElseThrow(() -> new RuntimeException("Course not found"));

        lesson.setCourse(course);
        return lessonRepo.save(lesson);
    }

    @Override
    public MicroLesson updateLesson(Long lessonId, MicroLesson lesson) {
        MicroLesson existing = lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));

        existing.setTitle(lesson.getTitle());
        existing.setDurationMinutes(lesson.getDurationMinutes());
        existing.setTags(lesson.getTags());
        existing.setContentType(lesson.getContentType());
        existing.setDifficulty(lesson.getDifficulty());

        return lessonRepo.save(existing);
    }

    @Override
    public List<MicroLesson> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType) {

        return lessonRepo.findByTagsContainingAndDifficultyAndContentType(
                tags,
                Difficulty.valueOf(difficulty),
                ContentType.valueOf(contentType)
        );
    }

    @Override
    public MicroLesson getLesson(Long lessonId) {
        return lessonRepo.findById(lessonId)
                .orElseThrow(() -> new RuntimeException("Lesson not found"));
    }
}
