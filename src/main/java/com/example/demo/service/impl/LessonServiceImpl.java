package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Course;
import com.example.demo.entity.MicroLesson;
import com.example.demo.repo.CourseRepository;
import com.example.demo.repo.MicroLessonRepository;
import com.example.demo.service.LessonService;

@Service
public class LessonServiceImpl implements LessonService {

    @Autowired
    private MicroLessonRepository lessonRepo;

    @Autowired
    private CourseRepository courseRepo;

    @Override
    public MicroLesson addLesson(Long courseId, MicroLesson lesson) {

        Course course = courseRepo.findById(courseId).orElse(null);
        lesson.setCourse(course);

        return lessonRepo.save(lesson);
    }

    @Override
    public MicroLesson updateLesson(Long lessonId, MicroLesson lesson) {

        MicroLesson existing = getLesson(lessonId);
        if (existing != null) {
            existing.setTitle(lesson.getTitle());
            existing.setDurationMinutes(lesson.getDurationMinutes());
            existing.setTags(lesson.getTags());
            existing.setDifficulty(lesson.getDifficulty());
            existing.setContentType(lesson.getContentType());
            return lessonRepo.save(existing);
        }
        return null;
    }

    @Override
    public List<MicroLesson> findLessonsByFilters(
            String tags,
            String difficulty,
            String contentType) {

        return lessonRepo
                .findByTagsContainingAndDifficultyAndContentType(
                        tags,
                        difficulty,
                        contentType
                );
    }

    @Override
    public MicroLesson getLesson(Long lessonId) {
        return lessonRepo.findById(lessonId).orElse(null);
    }
}
